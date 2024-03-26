package samuelfsd.com.br.myexpenses.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import samuelfsd.com.br.myexpenses.domain.model.User;
import samuelfsd.com.br.myexpenses.domain.repository.UserRepository;

import java.util.Optional;

public class UserDetailsSecurityServer implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOpt = userRepository.findByEmail(username);

        if (userOpt.isEmpty()) {
            throw new UsernameNotFoundException("Usuário ou senha inválidos");
        }

        return userOpt.get();
    }
}
