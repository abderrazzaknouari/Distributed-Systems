package ma.enset.billingservice.model;

import lombok.Data;
import lombok.Getter;

@Data
public class Customer {
    private Long id;
    private String name;
    private String email;
}
