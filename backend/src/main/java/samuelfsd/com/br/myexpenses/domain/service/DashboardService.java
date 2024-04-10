package samuelfsd.com.br.myexpenses.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    private RegistrationService registrationService;

}
