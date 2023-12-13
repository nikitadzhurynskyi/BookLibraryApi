package com.flamierd.booklibraryapi.domain.auth.service.impl;

import com.flamierd.booklibraryapi.core.exception.UnauthorizedException;
import com.flamierd.booklibraryapi.domain.auth.service.JwtUtilsService;
import com.flamierd.booklibraryapi.domain.auth.type.JwtTokenType;
import com.flamierd.booklibraryapi.domain.auth.web.model.JwtTokens;
import com.flamierd.booklibraryapi.domain.user.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtUtilsServiceImpl implements JwtUtilsService {
    @Value("${app.jwt.access.secret}")
    private String ACCESS_TOKEN_SECRET;

    @Value("${app.jwt.access.expiration}")
    private Long ACCESS_TOKEN_EXPIRATION;

    @Value("${app.jwt.refresh.secret}")
    private String REFRESH_TOKEN_SECRET;

    @Value("${app.jwt.refresh.expiration}")
    private Long REFRESH_TOKEN_EXPIRATION;

    @Override
    public JwtTokens generateTokens(User user) {
        String accessToken = generateToken(user, JwtTokenType.ACCESS);
        String refreshToken = generateToken(user, JwtTokenType.REFRESH);
        return new JwtTokens(accessToken, refreshToken);
    }

    @Override
    public String extractEmail(String token, JwtTokenType tokenType) {
        return extractClaim(token, tokenType, Claims::getSubject);
    }

    @Override
    public Long extractUserId(String token, JwtTokenType tokenType) {
        return extractAllClaims(token, tokenType).get("id", Long.class);
    }

    @Override
    public Date extractExpiration(String token, JwtTokenType tokenType) {
        return extractClaim(token, tokenType, Claims::getExpiration);
    }

    @Override
    public boolean isValid(String token, User user, JwtTokenType tokenType) {
        String username = extractEmail(token, tokenType);
        return user.getUsername().equals(username) && isNotTokenExpired(token, tokenType);
    }

    @Override
    public boolean isValid(String token, JwtTokenType tokenType) {
        return isNotTokenExpired(token, tokenType);
    }

    private boolean isTokenExpired(String token, JwtTokenType tokenType) {
        return extractExpiration(token, tokenType).before(new Date());
    }

    private boolean isNotTokenExpired(String token, JwtTokenType tokenType) {
        return !isTokenExpired(token, tokenType);
    }

    private <T> T extractClaim(String token, JwtTokenType jwtTokenType, Function<Claims, T> claimsResolvers) {
        Claims claims = extractAllClaims(token, jwtTokenType);
        return claimsResolvers.apply(claims);
    }

    private Claims extractAllClaims(String token, JwtTokenType tokenType) {
        try {
            return Jwts
                    .parserBuilder()
                    .setSigningKey(getSecretKeyByType(tokenType))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (JwtException ex) {
            throw new UnauthorizedException("Invalid jwt token. Unable to parse claims.");
        }
    }

    private String generateToken(User user, JwtTokenType tokenType) {
        return Jwts.builder()
                .claim("id", user.getId())
                .setSubject(user.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + getTokenExpirationByType(tokenType)))
                .signWith(getSecretKeyByType(tokenType))
                .compact();
    }

    private Long getTokenExpirationByType(JwtTokenType tokenType) {
        return tokenType.equals(JwtTokenType.ACCESS) ? ACCESS_TOKEN_EXPIRATION : REFRESH_TOKEN_EXPIRATION;
    }

    private String getTokenSecretByType(JwtTokenType tokenType) {
        return tokenType.equals(JwtTokenType.ACCESS) ? ACCESS_TOKEN_SECRET : REFRESH_TOKEN_SECRET;
    }

    private SecretKey getSecretKeyByType(JwtTokenType tokenType) {
        return Keys.hmacShaKeyFor(getTokenSecretByType(tokenType).getBytes());
    }
}
