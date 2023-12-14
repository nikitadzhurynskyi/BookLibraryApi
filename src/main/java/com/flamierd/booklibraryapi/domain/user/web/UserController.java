package com.flamierd.booklibraryapi.domain.user.web;

import com.flamierd.booklibraryapi.domain.user.model.User;
import com.flamierd.booklibraryapi.domain.user.service.UserService;
import com.flamierd.booklibraryapi.domain.user.web.model.UpdateRoleRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UserController {
    private final UserService userService;

    @PutMapping("/set-role")
    public User setUserRole(@RequestBody UpdateRoleRequest updateRoleRequest) {
        return userService.updateUserRole(updateRoleRequest);
    }
}
