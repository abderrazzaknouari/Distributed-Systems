package net.hassani.bankaccountservice.service;

import net.hassani.bankaccountservice.dtos.BankAccountDTO;
import net.hassani.bankaccountservice.entities.BankAccount;
import net.hassani.bankaccountservice.mappers.BankAccountMapper;
import net.hassani.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BankAccountServiceImpl implements IBankAccountService {
    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    private BankAccountRepository bankAccountRepository;
    @Override
    public List<BankAccountDTO> getAllAccounts() {
        List<BankAccount> accounts = bankAccountRepository.findAll();
        return BankAccountMapper.INSTANCE.toDtoList(accounts);
    }

    @Override
    public BankAccountDTO getAccountById(String id) {
        BankAccount bankAccount = bankAccountRepository.findById(id).orElse(null);
        return BankAccountMapper.INSTANCE.toDto(bankAccount);
    }

    @Override
    public BankAccountDTO saveAccount(BankAccountDTO account) {
        BankAccount bankAccount = BankAccountMapper.INSTANCE.toEntity(account);
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount = bankAccountRepository.save(bankAccount);
        return BankAccountMapper.INSTANCE.toDto(bankAccount);
    }

    @Override
    public BankAccountDTO updateAccount(BankAccountDTO account) {
        BankAccount bankAccount = bankAccountRepository.findById(account.getId()).orElse(null);
        if(account.getBalance() != null) {
            bankAccount.setBalance(account.getBalance());
        }
        if(account.getCurrency() != null) {
            bankAccount.setCurrency(account.getCurrency());
        }
        if(account.getAccountType() != null) {
            bankAccount.setAccountType(account.getAccountType());
        }
        if (account.getCreatedAt() != null) {
            bankAccount.setCreatedAt(account.getCreatedAt());
        }
        bankAccountRepository.save(bankAccount);
        return BankAccountMapper.INSTANCE.toDto(bankAccount);
    }

    @Override
    public void deleteAccount(String id) {
        bankAccountRepository.deleteById(id);
    }
}
