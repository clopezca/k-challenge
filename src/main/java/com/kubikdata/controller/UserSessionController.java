package com.kubikdata.controller;

import com.kubikdata.controller.request.UserSessionRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserSessionController {

    /**
     * this endpoint is needed to add a sesssion id to a specific username
     * @param userSessionRequest
     * @return
     */
    @PostMapping(value="/session")
    public ResponseEntity<String> addSession(@RequestBody UserSessionRequest userSessionRequest) {
        String body = "";
        ResponseEntity<String> response = new ResponseEntity<>(body, HttpStatus.OK);
        return response;
    }


}
