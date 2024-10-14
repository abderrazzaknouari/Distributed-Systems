package ma.enset.billingservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.billingservice.model.Customer;

import java.util.Collection;
import java.util.Date;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;
    private Long customerId;
    @OneToMany(mappedBy = "bill")
    private Collection<ProductItem> productItems;
    @Transient
    private Customer customer;
}
