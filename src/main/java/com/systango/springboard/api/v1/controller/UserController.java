package com.systango.springboard.api.v1.controller;

import com.systango.springboard.api.v1.request.AddUserRequest;
import com.systango.springboard.dto.model.user.UserDto;
import com.systango.springboard.service.exception.UserExistsException;
import com.systango.springboard.service.user.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by Arpit Khandelwal.
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {
    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserService userService,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid AddUserRequest addUserRequest) throws UserExistsException {
        UserDto userDto = new UserDto()
                .setUsername(addUserRequest.getUsername())
                .setPassword(bCryptPasswordEncoder.encode(addUserRequest.getPassword()));
        userService.addUser(userDto);
    }
}
