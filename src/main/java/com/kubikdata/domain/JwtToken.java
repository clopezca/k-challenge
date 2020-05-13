package com.kubikdata.domain;

import java.util.Objects;

public class JwtToken {
    private final String token;

    public JwtToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JwtToken jwtToken = (JwtToken) o;
        return Objects.equals(token, jwtToken.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }

}
