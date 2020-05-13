package com.kubikdata.service;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;

public class JwtBuilderGeneratorService {

    private final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(String username) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.ES256;

        HashMap<String, Object> header = new HashMap<>();
        header.put("alg", signatureAlgorithm.toString());
        header.put("typ", "JWT");

        JwtBuilder tokenJWT = Jwts.builder()
                .setHeader(header)
                .setSubject("kubikdata")
                .claim("username", username)
                .setIssuedAt(Date.from(Instant.ofEpochSecond(1466796822L)))
                .setExpiration(Date.from(Instant.ofEpochSecond(4622470422L)))
                .signWith(SECRET_KEY);

        String tokenJWTString = tokenJWT.compact();

        return tokenJWTString;
    }
}
