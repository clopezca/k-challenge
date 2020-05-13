package com.kubikdata.infrastructure;

import com.kubikdata.domain.JwtToken;
import com.kubikdata.domain.Username;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserSessionRepositoryImplShould {

    UserSessionRepositoryImpl userSessionRepository;

    @Test
    public void ensure_save_and_return_the_correct_username(){
        userSessionRepository = new UserSessionRepositoryImpl();
        Username expectedUsername = new Username("username");
        Username username = new Username("username");
        JwtToken token = new JwtToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoiNWVhYjJkMmUwNDgwNGU3YzgxNmE2YWRlIn0sImlhdCI6MTU4ODY4NjA4NSwiZXhwIjoxNTg4Njg5Njg1fQ.52x2bUKX9Je-4M4TXkZL-OfNOPHdwlfOdIO6km5YkZQ");
        userSessionRepository.save(username, token);

        Assertions.assertEquals(expectedUsername, userSessionRepository.find(username));
    }

    @Test
    public void update_user_token_with_a_new_token(){
        userSessionRepository = new UserSessionRepositoryImpl();
        Username username = new Username("username");
        JwtToken token = new JwtToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoiNWVhYjJkMmUwNDgwNGU3YzgxNmE2YWRlIn0sImlhdCI6MTU4ODY4NjA4NSwiZXhwIjoxNTg4Njg5Njg1fQ.52x2bUKX9Je-4M4TXkZL-OfNOPHdwlfOdIO6km5YkZQ");
        userSessionRepository.save(username, token);

        JwtToken newToken = new JwtToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoiNWVhYjJkMmUwNDgwNGU3YzgxNmE2YWRlIn0sImlhdCI6MTU4ODY4NjA4NSwiZXhwIjoxNTg4Njg5Njg1fQ.52x2bUKX9Je-4M4TXkZL-OfNOPHdwlfOdIO6km5YkQQ");
        userSessionRepository.update(username, newToken);

        Assertions.assertEquals(newToken, userSessionRepository.getToken(username));
    }

}