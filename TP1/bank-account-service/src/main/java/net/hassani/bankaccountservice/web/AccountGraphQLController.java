package net.hassani.bankaccountservice.web;

import net.hassani.bankaccountservice.dtos.BankAccountDTO;
import net.hassani.bankaccountservice.service.IBankAccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/graphql/accounts")
public class AccountGraphQLController {
    private final IBankAccountService bankAccountService;

    public AccountGraphQLController(IBankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }
    @QueryMapping
    public List<BankAccountDTO> getAllAccounts() {
        return bankAccountService.getAllAccounts();
    }
    @QueryMapping
    public BankAccountDTO getAccountById(@Argument String id) {
        return bankAccountService.getAccountById(id);
    }

    @MutationMapping
    public BankAccountDTO saveAccount(@Argument BankAccountDTO account) {
        return bankAccountService.saveAccount(account);
    }

    @MutationMapping
    public BankAccountDTO updateAccount(@Argument BankAccountDTO account) {
        return bankAccountService.updateAccount(account);
    }

    @MutationMapping
    public void deleteAccount(@Argument String id) {
        bankAccountService.deleteAccount(id);
    }
}
