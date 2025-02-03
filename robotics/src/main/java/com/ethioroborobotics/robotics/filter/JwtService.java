package com.ethioroborobotics.robotics.filter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtService {
//    private static final String SECRET_KEY="ceca1711e6e1ca017bca5fd14ce24dcbc89f3f9748c8b2b86ce5b631f36b4d5e";
    private static final long EXPIRATION_TIME=1000*60*60*24;

    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public static void main(String[] args) {
        // Convert the key to a byte array
        byte[] keyBytes = key.getEncoded();

        // Encode the byte array to Base64 for readability
        String base64Key = Base64.getEncoder().encodeToString(keyBytes);

        // Print the Base64 encoded key
        System.out.println("Base64 Encoded Key: " + base64Key);
    }

    public String generateToken(String username){
        Map<String,Object> claims=new HashMap<>();
        return createToken(claims,username);
    }
    public static String createToken(Map<String, Object> claims, String username){
        return Jwts.builder()
                .claims(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token, String username) {
        return extractUsername(token).equals(username) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }
}
