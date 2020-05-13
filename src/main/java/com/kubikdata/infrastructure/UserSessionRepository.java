package com.kubikdata.infrastructure;

import com.kubikdata.domain.JwtToken;
import com.kubikdata.domain.Username;

public interface UserSessionRepository {
    Username find(Username username);

    void save(Username username, JwtToken token);

    void update(Username username, JwtToken token);
}
