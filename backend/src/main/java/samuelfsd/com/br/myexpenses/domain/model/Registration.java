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
}
