package net.hassani.bankaccountservice.service;

import net.hassani.bankaccountservice.dtos.BankAccountDTO;
import net.hassani.bankaccountservice.entities.BankAccount;

import java.util.List;

public interface IBankAccountService {
    List<BankAccountDTO> getAllAccounts();
    BankAccountDTO getAccountById(String id);
    BankAccountDTO saveAccount(BankAccountDTO account);
    BankAccountDTO updateAccount(BankAccountDTO account);
    void deleteAccount(String id);
}
