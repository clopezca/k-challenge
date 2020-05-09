package com.kubikdata.controller;

import com.kubikdata.controller.request.UserDataRequest;
import com.kubikdata.controller.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * this class is used to return data info based on its session token,
 * choose one of the endpoints to return data info
 */
@RestController
public class UserDataController {

    @PostMapping(value = "/info")
    public ResponseEntity<UserResponse> userInfoPost(@RequestBody UserDataRequest userDataRequest) {
        UserResponse body = null;
        ResponseEntity<UserResponse> response = new ResponseEntity<>(body, HttpStatus.OK);
        return response;
    }

    @GetMapping(value = "/info/{username}/{token}")
    public ResponseEntity<UserResponse> userInfoGet(@PathVariable String username, @PathVariable String token) {
        UserResponse body = null;
        ResponseEntity<UserResponse> response = new ResponseEntity<>(body, HttpStatus.OK);
        return response;
    }
}
