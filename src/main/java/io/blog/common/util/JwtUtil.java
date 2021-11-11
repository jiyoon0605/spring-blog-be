package io.blog.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

public class JwtUtil {


    public String createToken(Long id, String email, String key) {
        Date ext = new Date();
        Long expiredTime = 60 * 60 * 24 * 365L;
        ext.setTime(ext.getTime() + expiredTime);

        String token = Jwts
                .builder()
                .claim("id", id)
                .claim("email", email)
                .signWith(SignatureAlgorithm.HS256, key.getBytes())
                .setExpiration(ext)
                .compact();
        return token;
    }

    public Map<String, Object> verifyJWT(String key, String auth) throws UnsupportedEncodingException {
        Map<String, Object> claimMap = null;
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(key.getBytes("UTF-8"))
                    .parseClaimsJwt(auth)
                    .getBody();
            claimMap = claims;
            claimMap.put("success",true);
        } catch (ExpiredJwtException e) {
            claimMap.put("success",false);
        } catch (Exception e) {
            claimMap.put("success",false);
        }
        return claimMap;
    }
}
