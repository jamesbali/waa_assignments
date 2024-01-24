package edu.miu.WebAppArchLab.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenUtil {

    public String generateToken(UserDetails userDetails) {

        return null;

    }
    //Validate token
    public boolean validateToken(String token, UserDetails userDetails) {
        // TODO Auto-generated method stub
        return false;
    }

}
