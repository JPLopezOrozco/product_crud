package juan.product_crud.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY = "cf3e47f23412a6af90e314e06986126ed1e7c831136910d197da939e0b96161dfd02d80c330f81c6c2d6ca579c7497cd1b453cb5612ac776a3a0c08052477bf45a706d7a20cea68f213ca0f44bdb15cb37e155ecec9b97f0d57a0306ba4d7c63b6177300c7ae203c4609c60b14cddaf9086b795636e1cdd4ce098c8dd5ee189b26448d8c4f44b0b7ec0941d4169243eff3249a25350c011544d7b84b2d9fe92fbdf0b4f3019d11fc97da11eff48e6a22584c09b316bbe0e33d5eb2f68684d0da2bc17b58d3781b2a00bbf2ec19ecf84a9ea46589ea6d16419ecea71ad5ebd4fa7080d563a1c5aaf78e241595657dd2a34522375cb40ab6ba6fef2b1253e993a7";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<> (), userDetails);
    }

    public String generateToken(Map<String, Object> extractClaims,
                                UserDetails userDetails) {
        return Jwts
                .builder()
                .setClaims(extractClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY)  ;
        return Keys.hmacShaKeyFor(keyBytes);
    }


}
