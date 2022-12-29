package us.proentel.jwt;


import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

  /*  @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;*/
  public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    private static final String SECRET = "proentel";
    private static final String ISS = "echisan";

    // clave de rol
    private static final String ROLE_CLAIMS = "rol";

    public static final String SUBJECT = "congge";

    // El tiempo de caducidad es 3600 segundos, que es 1 hora
    private static final long EXPIRATION = 43600L;

    // Después de elegir recuérdame, el tiempo de caducidad es de 7 días
    private static final long EXPIRATION_REMEMBER = 604800L;

    public String getJWTToken(String username, String id, String rol) {
        long expiration = EXPIRATION_REMEMBER ;
        String role=rol;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(ROLE_CLAIMS, role);

        return
                Jwts.builder()
                        .signWith(SignatureAlgorithm.HS512, SECRET)
                        .setClaims(map)
                        .setIssuer(ISS)
                        .setSubject(username)
                        .setIssuedAt(new Date())
                        .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                        .compact();


        /*
        String secretKey = "proentel";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("Ruben")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,secretKey).compact();
        return  token;
        */

    }

    // Obtén el nombre de usuario del token
    public static String getUsername(String token){
        //return getTokenBody(token).getSubject();

        Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        return claims.get("name").toString();

    }

    // Obtener rol de usuario
    public  String getUserRole(String token){
        return (String) getTokenBody(token).get(ROLE_CLAIMS);
    }

    // ¿Está vencido?
    public static boolean isExpiration(String token){
        return getTokenBody(token).getExpiration().before(new Date());
    }

    private static Claims getTokenBody(String token){
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    public String getNombreUsuarioFromToken(String token){
        return Jwts.parser().setSigningKey("proentel").parseClaimsJws(token).getBody().getSubject();
    }


    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey("proentel").parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException e){
            logger.error("token mal formado");
        }catch (UnsupportedJwtException e){
            logger.error("token no soportado");
        }catch (ExpiredJwtException e){
            logger.error("token expirado");
        }catch (IllegalArgumentException e){
            logger.error("token vacío");
        }catch (SignatureException e){
            logger.error("fail en la firma");
        }
        return false;
    }
}
