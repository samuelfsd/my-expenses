package samuelfsd.com.br.myexpenses.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samuelfsd.com.br.myexpenses.domain.Enum.TypeRegistration;
import samuelfsd.com.br.myexpenses.dto.Registration.RegistrationResponseDTO;
import samuelfsd.com.br.myexpenses.dto.dashboard.DashboardResponseDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private RegistrationService registrationService;

    public DashboardResponseDTO getCashFlow(String startDate, String endDate) {

        List<RegistrationResponseDTO> registrations = registrationService.getByExpirationDate(startDate, endDate);

        Double totalPayable = 0.0;
        Double totalReceivable = 0.0;
        Double balance = 0.0;

        List<RegistrationResponseDTO> registrationsPayable = new ArrayList<>();
        List<RegistrationResponseDTO> registrationsReceivable = new ArrayList<>();

        for(RegistrationResponseDTO registration : registrations) {
            if (registration.getType() == TypeRegistration.PAYABLE) {
                totalPayable += registration.getValue();
                registrationsPayable.add(registration);
            }
            totalReceivable += registration.getValue();
            registrationsReceivable.add(registration);
        }

        balance = totalPayable  - totalReceivable;

        return new DashboardResponseDTO(totalPayable, totalReceivable, balance, registrationsPayable, registrationsReceivable);
    }
}
