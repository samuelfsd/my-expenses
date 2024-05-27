package samuelfsd.com.br.myexpenses.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import samuelfsd.com.br.myexpenses.domain.model.User;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${auth.jwt.secret}")
    private String jwtSecret;

    @Value("${auth.jwt-expiration-time}")
    private Long jwtExpirationTime;


    public String createToken(Authentication auth) {
        // get time + expiration time
        Date dateExpiration = new Date(new Date().getTime() + jwtExpirationTime);

        // cast object to user
        User user = (User) auth.getPrincipal();

        try {

            // generate key
            Key secretKey = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));

            return Jwts.builder()
                    .setSubject(user.getUsername())
                    .setIssuedAt(new Date())
                    .setExpiration(dateExpiration)
                    .signWith(secretKey)
                    .compact();

        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return "";
        }
    }

    private Claims getClaims(String token) {
        try {

            // generate key
            Key secretKey = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));

            return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getUserName(String token) {
        Claims claims = getClaims(token);

        if (claims == null) return null;

        return claims.getSubject();
    }

    public boolean isValidToken(String token) {
        Claims claims = getClaims(token);

        if (claims == null) return false;

        String email = claims.getSubject();
        Date dateExpiration = claims.getExpiration();

        Date now = new Date(System.currentTimeMillis());

        if(email == null && now.after(dateExpiration)){
            return false;
        }

        return true;
    }
}
