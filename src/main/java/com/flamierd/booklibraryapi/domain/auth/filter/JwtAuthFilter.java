package com.flamierd.booklibraryapi.domain.auth.filter;

import com.flamierd.booklibraryapi.core.exception.BookLibraryException;
import com.flamierd.booklibraryapi.domain.auth.service.JwtUtilsService;
import com.flamierd.booklibraryapi.domain.auth.type.JwtTokenType;
import com.flamierd.booklibraryapi.domain.user.model.User;
import com.flamierd.booklibraryapi.domain.user.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@AllArgsConstructor
@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private final JwtUtilsService jwtUtilsService;
    private final UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            String authorizationHeader = request.getHeader(AUTHORIZATION_HEADER);
            String accessToken = parseTokenFromHeader(authorizationHeader);

            if (accessToken == null) {
                filterChain.doFilter(request, response);
                return;
            }

            if (!jwtUtilsService.isValid(accessToken, JwtTokenType.ACCESS)) {
                filterChain.doFilter(request, response);
                return;
            }


            User user = userService.findByEmail(jwtUtilsService.extractEmail(accessToken, JwtTokenType.ACCESS)).orElse(null);

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user,
                    null,
                    user == null ? null : user.getAuthorities());

            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            filterChain.doFilter(request, response);
        } catch (BookLibraryException ex) {
            filterChain.doFilter(request, response);
        }
    }

    private String parseTokenFromHeader(String header) {
        if (header == null || !header.startsWith("Bearer ")) {
            return null;
        }
        return header.substring(7);
    }
}
