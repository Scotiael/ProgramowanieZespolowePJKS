package com.programowanie.zespolowe.pz.authapi.security;

public class SecurityConstants {
    public static final String SECRET = "SoSecret";
    public static final long EXPIRATION_TIME = 14_400_000; // 4 hours
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/user/register";
    public static final String LOGIN_URL = "/user/login";
}
