package samuelfsd.com.br.myexpenses.dto.dashboard;

import samuelfsd.com.br.myexpenses.dto.Registration.RegistrationResponseDTO;

import java.util.List;

public class DashboardResponseDTO {
    private Double totalPayable;
    private Double totalReceivable;

    private Double balance;

    private List<RegistrationResponseDTO> registrationsPayable;

    private List<RegistrationResponseDTO> registrationsReceivable;


    public DashboardResponseDTO() {}

    public DashboardResponseDTO(Double totalPayable, Double totalReceivable, Double balance, List<RegistrationResponseDTO> registrationsPayable, List<RegistrationResponseDTO> registrationsReceivable) {
        this.totalPayable = totalPayable;
        this.totalReceivable = totalReceivable;
        this.balance = balance;
        this.registrationsPayable = registrationsPayable;
        this.registrationsReceivable = registrationsReceivable;
    }

    public Double getTotalPayable() {
        return totalPayable;
    }

    public void setTotalPayable(Double totalPayable) {
        this.totalPayable = totalPayable;
    }

    public Double getTotalReceivable() {
        return totalReceivable;
    }

    public void setTotalReceivable(Double totalReceivable) {
        this.totalReceivable = totalReceivable;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<RegistrationResponseDTO> getRegistrationsPayable() {
        return registrationsPayable;
    }

    public void setRegistrationsPayable(List<RegistrationResponseDTO> registrationsPayable) {
        this.registrationsPayable = registrationsPayable;
    }

    public List<RegistrationResponseDTO> getRegistrationsReceivable() {
        return registrationsReceivable;
    }

    public void setRegistrationsReceivable(List<RegistrationResponseDTO> registrationsReceivable) {
        this.registrationsReceivable = registrationsReceivable;
    }
}
