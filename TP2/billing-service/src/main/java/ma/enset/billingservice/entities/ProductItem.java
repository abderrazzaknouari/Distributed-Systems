package ma.enset.billingservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import ma.enset.billingservice.model.Product;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder @ToString
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    private double quantity;
    private Long productId;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Bill bill;
    @Transient
    private Product product;
}
