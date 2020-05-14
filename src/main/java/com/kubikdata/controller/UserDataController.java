package com.kubikdata.controller;

import com.kubikdata.controller.request.UserDataRequest;
import com.kubikdata.controller.response.UserResponse;
import com.kubikdata.infrastructure.UserSessionRepository;
import com.kubikdata.service.JwtBuilderGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserSessionService;

import java.util.NoSuchElementException;

/**
 * this class is used to return data info based on its session token,
 * choose one of the endpoints to return data info
 */
@RestController
public class UserDataController {

    @Autowired
    JwtBuilderGeneratorService jwtBuilderGeneratorService;

    @Autowired
    UserSessionRepository userSessionRepository;

    @PostMapping(value = "/info")
    public ResponseEntity<UserResponse> userInfoPost(@RequestBody UserDataRequest userDataRequest) {
        UserResponse body = null;
        ResponseEntity<UserResponse> response = new ResponseEntity<>(body, HttpStatus.OK);
        return response;
    }

    @GetMapping(value = "/info/{username}/{token}")
    public ResponseEntity<Object> userInfoGet(@PathVariable String username, @PathVariable String token) {
        UserSessionService userSessionService = new UserSessionService(jwtBuilderGeneratorService, userSessionRepository);

        try{
            UserResponse body = userSessionService.checkUserSession(username, token);

            return new ResponseEntity<>(body, HttpStatus.OK);

        } catch (NoSuchElementException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }


    }
}
