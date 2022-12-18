package com.aadi.conduit.services;

import com.aadi.conduit.entities.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Service
public class JWTService {

    //TODO : Dont keep it in source code put it in properties file
    public static final String JWT_KEY = "XJcUfW1ZA4xZndJZrer2KzxfHnVsyPWkw91eyqlMie3e9H86hdlKmbmbyPc7SpF3" ;
    public static final int JWT_EXPIRY_AGE = 1000 * 60 * 60 * 24 * 7 ;

    private Key key = Keys.hmacShaKeyFor(JWT_KEY.getBytes(StandardCharsets.UTF_8));
    JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(key).build();

    public String createJWT(UserEntity userEntity){
        return Jwts.builder()
                .setSubject(userEntity.getUserName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRY_AGE))
                .signWith(key).compact();
    }

    public String decodeJWT( String jwts){
        Claims claims = jwtParser.parseClaimsJwt(jwts).getBody();
        return claims.getSubject();
    }
}
