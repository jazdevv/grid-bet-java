package com.gridbetjavaa.gridbetjavaa.utils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public String generateToken(Long id) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 86400000);

        Map<String, Object> claims = new HashMap<>();
        claims.put("id", id);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(secretKey, SignatureAlgorithm.HS512)
                .compact();
    }

    public Long extractUserId(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
        return (Long) claims.get("id");
    }
}