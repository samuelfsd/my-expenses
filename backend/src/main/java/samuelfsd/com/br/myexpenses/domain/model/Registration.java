package samuelfsd.com.br.myexpenses.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import samuelfsd.com.br.myexpenses.domain.Enum.TypeRegistration;

import java.util.Date;
import java.util.List;

@Entity
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id")
    private Long id;

    @Column(nullable = false)
    private String description;

    private TypeRegistration type;

    @Column(nullable = false)
    private Double value;

    private Date created_at;

    private Date date_reference;

    private Date expiration_date;

    private Date payment_date;

    @ManyToMany
    @JoinTable(
            name = "registration_costcenter",
            joinColumns = @JoinColumn(name = "registration_id"),
            inverseJoinColumns = @JoinColumn(name = "costcenter_id")
    )
    private List<CostCenter> costCenters;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(columnDefinition = "TEXT")
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

    public List<CostCenter> getCostCenters() {
        return costCenters;
    }

    public void setCostCenters(List<CostCenter> costCenters) {
        this.costCenters = costCenters;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
