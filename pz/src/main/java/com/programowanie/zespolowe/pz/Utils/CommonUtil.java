package com.programowanie.zespolowe.pz.Utils;

import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;

import static com.programowanie.zespolowe.pz.authapi.security.SecurityConstants.HEADER_STRING;
import static com.programowanie.zespolowe.pz.authapi.security.SecurityConstants.SECRET;
import static com.programowanie.zespolowe.pz.authapi.security.SecurityConstants.TOKEN_PREFIX;

public class CommonUtil {

    static Logger log = LoggerFactory.getLogger(CommonUtil.class);

    public static String getTokenFromHeader(HttpHeaders header){
        try {
            String token = header.get(HEADER_STRING).get(0);
            String userEmail = Jwts.parser()
                    .setSigningKey(SECRET.getBytes())
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();
            return userEmail;
        }catch (Exception e){
            log.warn("Exception parsing token", e);
            return null;
        }
    }

}
