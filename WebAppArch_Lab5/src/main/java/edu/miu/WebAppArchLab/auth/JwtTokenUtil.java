package edu.miu.WebAppArchLab.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil implements Serializable {

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();

        return doGenerateToken(claims, userDetails.getUsername());

    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {

        String secret = "mySecretKey";
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
    public String getUserNameFromToken(String token) {


        return Jwts.parser()
                .setSigningKey("mySecretKey")
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token, UserDetails userDetails) {

        final String username = getUserNameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));

    }
    private boolean isTokenExpired(String token) {

        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public Date getExpirationDateFromToken(String token) {

        return Jwts.parser()
                .setSigningKey("mySecretKey")
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();

    }



//    public String generateToken(UserDetails userDetails) {
//
//        return null;
//
//    }
//    //Validate token
//    public boolean validateToken(String token, UserDetails userDetails) {
//        // TODO Auto-generated method stub
//        return false;
//    }

}
