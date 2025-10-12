package barberia.barber.security;

import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    public static final String SECRET_KEY = "EstaEsTuClaveSecretaSuperSegura123!";
    public static final long EXPIRATION_TIME = 86400000; // 1 día en milisegundos
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

}
