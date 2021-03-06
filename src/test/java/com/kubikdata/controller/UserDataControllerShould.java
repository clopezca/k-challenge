package com.kubikdata.controller;

import com.kubikdata.domain.Username;
import com.kubikdata.infrastructure.UserSessionRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserDataControllerShould {
    String username = "username";
    String jwtToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoiNWVhYjJkMmUwNDgwNGU3YzgxNmE2YWRlIn0sImlhdCI6MTU4ODY4NjA4NSwiZXhwIjoxNTg4Njg5Njg1fQ.52x2bUKX9Je-4M4TXkZL-OfNOPHdwlfOdIO6km5YkZQ";


    @InjectMocks
    UserDataController userDataController;

    @Mock
    UserSessionRepository userSessionRepository;

    @Test
    public void show_user_session_details() {

        when(userSessionRepository.find(new Username(username))).thenReturn(new Username(username));

        ResponseEntity<Object> response = userDataController.userInfoGet(username, jwtToken);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void retrieve_error_when_server_are_unavailable_trying_get_user_info() {

        when(userSessionRepository.find(new Username(username))).thenThrow(new RuntimeException());

        ResponseEntity<Object> response = userDataController.userInfoGet(username, jwtToken);

        Assert.assertEquals(HttpStatus.SERVICE_UNAVAILABLE, response.getStatusCode());
    }

    @Test
    public void throw_an_error_if_token_is_empty_when_trying_to_retrieve_user_info() {

        ResponseEntity<Object> response = userDataController.userInfoGet(username, "");

        Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}