package samuelfsd.com.br.myexpenses.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import samuelfsd.com.br.myexpenses.domain.model.CostCenter;

public interface CostCenterRepository extends JpaRepository<CostCenter, Long> {}
