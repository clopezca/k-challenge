package com.kubikdata.infrastructure;

import com.kubikdata.domain.JwtToken;
import com.kubikdata.domain.Username;

import java.util.LinkedHashMap;
import java.util.Map;

public class UserSessionRepositoryImpl implements UserSessionRepository {

    protected Map<Username, JwtToken> userSessionList = new LinkedHashMap<>();


    @Override
    public Username find(Username username) {
        for (Username existingUser : userSessionList.keySet()) {
            if (existingUser.equals(username)) return username;
        }
        return null;
    }

    @Override
    public void save(Username username, JwtToken token) {
        userSessionList.put(username, token);
    }

    @Override
    public void update(Username username, JwtToken token) {
        for (Username existingUser : userSessionList.keySet()) {
            if (existingUser.equals(username)) userSessionList.put(username, token);
        }
    }

    @Override
    public JwtToken getToken(Username username) {
        if (userSessionList.get(username) == null) return null;
        return userSessionList.get(username);
    }
}
