package samuelfsd.com.br.myexpenses.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import samuelfsd.com.br.myexpenses.domain.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
