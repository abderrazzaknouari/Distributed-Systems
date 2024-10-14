package net.hassani.bankaccountservice.repositories;

import net.hassani.bankaccountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@RestResource
public interface BankAccountRepository extends JpaRepository<BankAccount, String>{
}
