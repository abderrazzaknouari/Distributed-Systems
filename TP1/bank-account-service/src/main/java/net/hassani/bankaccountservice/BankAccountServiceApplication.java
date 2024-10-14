package net.hassani.bankaccountservice;

import net.hassani.bankaccountservice.entities.BankAccount;
import net.hassani.bankaccountservice.enums.AccountType;
import net.hassani.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Random;

@SpringBootApplication
public class BankAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository) {
        return args -> {
            Random random = new Random();
            BankAccount bankAccount1 = BankAccount.builder()
                    .id("BA001")
                    .createdAt(new Date())
                    .balance(1000)
                    .currency("USD")
                    .accountType(random.nextBoolean() ? AccountType.SAVING_ACCOUNT : AccountType.CURRENT_ACCOUNT)
                    .build();
            BankAccount bankAccount2 = BankAccount.builder()
                    .id("BA002")
                    .createdAt(new Date())
                    .balance(1000)
                    .currency("EUR")
                    .accountType(random.nextBoolean() ? AccountType.SAVING_ACCOUNT : AccountType.CURRENT_ACCOUNT)
                    .build();
            BankAccount bankAccount3 = BankAccount.builder()
                    .id("BA003")
                    .createdAt(new Date())
                    .balance(1000)
                    .currency("DH")
                    .accountType(random.nextBoolean() ? AccountType.SAVING_ACCOUNT : AccountType.CURRENT_ACCOUNT)
                    .build();
            bankAccountRepository.save(bankAccount1);
            bankAccountRepository.save(bankAccount2);
            bankAccountRepository.save(bankAccount3);

        };
    }
}
