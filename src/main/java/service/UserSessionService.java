package service;

import com.kubikdata.controller.response.UserResponse;
import com.kubikdata.domain.JwtToken;
import com.kubikdata.domain.Username;
import com.kubikdata.infrastructure.UserSessionRepository;
import com.kubikdata.service.JwtBuilderGeneratorService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.NoSuchElementException;

@Service
public class UserSessionService {
    private final JwtBuilderGeneratorService jwtBuilderGeneratorService;
    private final UserSessionRepository userSessionRepository;

    public UserSessionService(JwtBuilderGeneratorService jwtBuilderGeneratorService, UserSessionRepository userSessionRepository) {
        this.jwtBuilderGeneratorService = jwtBuilderGeneratorService;
        this.userSessionRepository = userSessionRepository;
    }

    public String addSession(Username username) {
        Username user = userSessionRepository.find(username);
        JwtToken token = new JwtToken(jwtBuilderGeneratorService.generateToken(username.getUsername()));
        if(user == null) {
            userSessionRepository.save(username, token);
        } userSessionRepository.update(username, token);
        return token.getToken();
    }

    public UserResponse checkUserSession(String username, String token) {
        Username user = userSessionRepository.find(new Username(username));
        if(user == null) throw new NoSuchElementException();
        return new UserResponse(username, token, new Date());
    }
}


