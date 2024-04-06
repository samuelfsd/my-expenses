package samuelfsd.com.br.myexpenses.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import samuelfsd.com.br.myexpenses.domain.model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {}
