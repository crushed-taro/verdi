package verdi_server.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import verdi_server.member.dto.TokenDTO;
import verdi_server.member.entity.Member;
import verdi_server.member.entity.MemberRole;

import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class TokenProvider {

    private static final Logger log = LoggerFactory.getLogger(TokenProvider.class);
    private static final String AUTHORITIES_KEY = "auth";
    private static final String BEARER_TYPE = "bearer";
    private static final long ACCESS_TOKEN_EXPIRE_TIME = 1000 * 60 * 30; // 30분

    private final UserDetailsService userDetailsService;

    private final Key key;

    public TokenProvider(UserDetailsService userDetailsService, @Value("${jwt.secret}") String secretKey) {
        this.userDetailsService = userDetailsService;
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public TokenDTO generateTokenDTO(Member member) {

        log.info("[TokenProvider] generateTokenDTO() Start");

        List<String> roles = new ArrayList<>();

        for(MemberRole memberRole : member.getMemberRole()) {
            roles.add(memberRole.getAuthority().getAuthorityName());
        }

        log.info("[TokenProvider] authorized authorities {} : ", roles);

        long now = System.currentTimeMillis();
        Date accessTokenExpriesIn = new Date(now + ACCESS_TOKEN_EXPIRE_TIME);

        String accessToken = Jwts.builder()
                        .setSubject(member.getEmail())
                        .claim(AUTHORITIES_KEY, roles)
                        .setExpiration(accessTokenExpriesIn)
                        .signWith(key, SignatureAlgorithm.ES512)
                        .compact();

        log.info("조립된 accessToken 확인 = ", accessToken);

        log.info("[TokenProvider] generateTokenDTO() End");

        return new TokenDTO(BEARER_TYPE, member.getName(), accessToken, accessTokenExpriesIn.getTime());
    }

    public String getUserId(String token) {
        log.info("[TokenProvider] getUserId() Call...");
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public Authentication getAuthentication(String token) {
        log.info("[TokenProvider] getAuthentication() Start");

        Claims claims = parseClaims(token);



        log.info("[TokenProvider] getAuthentication() End");

    }

    private Claims parseClaims(String token) {
        log.info("[TokenProvider] parseClaims() Call...");
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }

    }

}
