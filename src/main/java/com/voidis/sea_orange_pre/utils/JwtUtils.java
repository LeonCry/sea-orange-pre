package com.voidis.sea_orange_pre.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JwtUtils {
    private static final String SECRET_KEY = "secret_key_sea_orange_pre";
    private static final long EXPIRE_TIME = 60 * 1000;

    public static String generateToken(Long userId, String username) {
        Date now = new Date();
        Date expire = new Date(now.getTime() + EXPIRE_TIME);
        return JWT.create().withClaim("id", userId)
                .withClaim("user≈name", username)
                .withExpiresAt(expire)
                .sign(Algorithm.HMAC256(SECRET_KEY));
    }
    public static DecodedJWT verifyToken(String token) {
        return JWT.require(Algorithm.HMAC256(SECRET_KEY))
                .build()
                .verify(token);
    }
}
