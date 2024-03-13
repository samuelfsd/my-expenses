package samuelfsd.com.br.myexpenses.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtAuthFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    private JwtUtil jwtUtil;

    public JwtAuthFilter(AuthenticationManager authenticationManager, AuthenticationManager authenticationManager1, JwtUtil jwtUtil) {
        super();
        this.authenticationManager = authenticationManager1;
        this.jwtUtil = jwtUtil;

        setFilterProcessesUrl("/api/auth");
    }
}
