package com.kubikdata.controller;

import com.kubikdata.domain.Username;
import com.kubikdata.domain.JwtToken;
import com.kubikdata.controller.request.UserSessionRequest;
import com.kubikdata.infrastructure.UserSessionRepository;
import com.kubikdata.service.JwtBuilderGeneratorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class UserSessionControllerShould {

    @Mock
    JwtBuilderGeneratorService jwtBuilderGeneratorService;

    @Mock
    UserSessionRepository userSessionRepository;

    @InjectMocks
    UserSessionController userSessionController;

    JwtToken jwtToken = new JwtToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoiNWVhYjJkMmUwNDgwNGU3YzgxNmE2YWRlIn0sImlhdCI6MTU4ODY4NjA4NSwiZXhwIjoxNTg4Njg5Njg1fQ.52x2bUKX9Je-4M4TXkZL-OfNOPHdwlfOdIO6km5YkZQ");

    @Test
    public void create_an_user_session_correctly(){
        MockitoAnnotations.initMocks(this);

        when(userSessionRepository.find(new Username("Username"))).thenReturn(null);
        when(jwtBuilderGeneratorService.generateToken("Username")).thenReturn("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoiNWVhYjJkMmUwNDgwNGU3YzgxNmE2YWRlIn0sImlhdCI6MTU4ODY4NjA4NSwiZXhwIjoxNTg4Njg5Njg1fQ.52x2bUKX9Je-4M4TXkZL-OfNOPHdwlfOdIO6km5YkZQ");

        UserSessionRequest userSessionRequest = new UserSessionRequest();
        userSessionRequest.setUsername("Username");
        ResponseEntity<String> response = userSessionController.addSession(userSessionRequest);

        verify(userSessionRepository).save(new Username("Username"), jwtToken);

        Assertions.assertEquals(jwtToken.getToken(), response.getBody());
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}



