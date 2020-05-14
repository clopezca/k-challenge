package com.kubikdata.service;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;


@Component
public class JwtBuilderGeneratorService {

    public String generateToken(String username) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.ES256;
        SecretKey secretKey = MacProvider.generateKey(SignatureAlgorithm.HS256);

        HashMap<String, Object> header = new HashMap<>();
        header.put("alg", signatureAlgorithm.toString());
        header.put("typ", "JWT");

        JwtBuilder tokenJWT = Jwts.builder()
                .setHeader(header)
                .setSubject("kubikdata")
                .claim("username", username)
                .setIssuedAt(Date.from(Instant.ofEpochSecond(1466796822L)))
                .setExpiration(Date.from(Instant.ofEpochSecond(4622470422L)))
                .signWith(secretKey);

        return tokenJWT.compact();
    }
}
