package com.kubikdata.infrastructure;

import com.kubikdata.domain.JwtToken;
import com.kubikdata.domain.Username;

public class UserSessionRepositoryImpl implements UserSessionRepository {
    @Override
    public Username find(Username username) {
        return null;
    }

    @Override
    public void save(Username username, JwtToken token) {

    }

    @Override
    public void update(Username username, JwtToken token) {

    }
}
