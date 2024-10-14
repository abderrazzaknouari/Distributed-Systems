package net.hassani.bankaccountservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import net.hassani.bankaccountservice.enums.AccountType;

import java.util.Date;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class BankAccount {
    @Id
    private String id;
    private Date createdAt;
    private double balance;
    private String currency;
    private AccountType accountType;
}
