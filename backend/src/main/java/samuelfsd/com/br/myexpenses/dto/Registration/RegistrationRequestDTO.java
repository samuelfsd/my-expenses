package samuelfsd.com.br.myexpenses.dto.Registration;

import samuelfsd.com.br.myexpenses.domain.Enum.TypeRegistration;
import samuelfsd.com.br.myexpenses.dto.CostCenter.CostCenterRequestDTO;

import java.util.Date;
import java.util.List;

public class RegistrationRequestDTO {
    private Long id;

    private String description;

    private TypeRegistration type;

    private Double value;

    private Date created_at;

    private Date date_reference;

    private Date expiration_date;

    private Date payment_date;


    private List<CostCenterRequestDTO> costCenters;


    private String observation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeRegistration getType() {
        return type;
    }

    public void setType(TypeRegistration type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getDate_reference() {
        return date_reference;
    }

    public void setDate_reference(Date date_reference) {
        this.date_reference = date_reference;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public List<CostCenterRequestDTO> getCostCenters() {
        return costCenters;
    }

    public void setCostCenters(List<CostCenterRequestDTO> costCenters) {
        this.costCenters = costCenters;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
