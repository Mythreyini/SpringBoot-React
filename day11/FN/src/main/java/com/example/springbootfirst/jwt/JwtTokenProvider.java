package com.example.springbootfirst.jwt;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;


@Component
public class JwtTokenProvider {
    @Value("${app.jwt-secret}")
    private String jwtSecret;
    @Value("${app.jwt-expiration-milliseconds}")
    private long jwtExpirationMilliSeconds;


    private Key secretKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }


    public String generateToken(Authentication authenticate){
        UserDetails userPrincipal= (UserDetails) authenticate.getPrincipal();
        return Jwts.builder()              //to generate json web token ,built and compact it
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+jwtExpirationMilliSeconds))
                .signWith(secretKey(), SignatureAlgorithm.HS256)
                .compact();
    }


//to get username from token
    public  String getUserNameFromToken(String token){
        return Jwts.parserBuilder()
                .setSigningKey(secretKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }




    public boolean validateToken(String token){
    try{
        Jwts.parserBuilder()
                .setSigningKey(secretKey())
                .build()
                .parseClaimsJws(token);
        return true;
    }catch (JwtException | IllegalArgumentException e){
        e.printStackTrace();
    }
    return false;
    }

}
