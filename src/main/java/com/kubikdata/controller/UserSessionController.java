package com.kubikdata.controller;

import com.kubikdata.controller.request.UserSessionRequest;
import com.kubikdata.domain.Username;
import com.kubikdata.infrastructure.UserSessionRepository;
import com.kubikdata.service.JwtBuilderGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.UserSessionService;

@RestController
public class UserSessionController {

    /**
     * this endpoint is needed to add a sesssion id to a specific username
     * @param userSessionRequest
     * @return
     */

    @Autowired
    JwtBuilderGeneratorService jwtBuilderGeneratorService;

    @Autowired
    UserSessionRepository userSessionRepository;

    @PostMapping(value="/session")
    public ResponseEntity<String> addSession(@RequestBody UserSessionRequest userSessionRequest) {

        UserSessionService userSessionService = new UserSessionService(jwtBuilderGeneratorService, userSessionRepository);
        String response = userSessionService.addSession(new Username(userSessionRequest.getUsername()));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
