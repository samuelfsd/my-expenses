package samuelfsd.com.br.myexpenses.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import samuelfsd.com.br.myexpenses.domain.model.Registration;

import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM public.registration " +
        "WHERE expiration_date " +
        "BETWEEN TO_TIMESTAMP(:startDate, 'YYYY-MM-DD hh24:MI:SS') AND " +
        "TO_TIMESTAMP(:endDate, 'YYYY-MM-DD hh24:MI:SS')"
    )
    List<Registration> getCashFlowByExpirationDate(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
