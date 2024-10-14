package net.hassani.bankaccountservice.dtos;

import lombok.*;
import net.hassani.bankaccountservice.enums.AccountType;

import java.util.Date;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class BankAccountDTO {
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    private AccountType accountType;
}
