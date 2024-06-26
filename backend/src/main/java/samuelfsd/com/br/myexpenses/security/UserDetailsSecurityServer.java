package samuelfsd.com.br.myexpenses.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import samuelfsd.com.br.myexpenses.domain.model.User;
import samuelfsd.com.br.myexpenses.domain.repository.UserRepository;

import java.util.ArrayList;
import java.util.Optional;


@Component
public class UserDetailsSecurityServer implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOpt = userRepository.findByEmail(username);

        if (userOpt.isEmpty()) {
            throw new UsernameNotFoundException("Usuário ou senha inválidos");
        }

        return new org.springframework.security.core.userdetails.User(userOpt.get().getEmail(), userOpt.get().getPassword(), new ArrayList<>());
    }
}
