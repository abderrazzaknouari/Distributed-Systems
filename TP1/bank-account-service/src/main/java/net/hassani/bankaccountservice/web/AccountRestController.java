package net.hassani.bankaccountservice.web;

import net.hassani.bankaccountservice.dtos.BankAccountDTO;
import net.hassani.bankaccountservice.service.IBankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountRestController {
    private final IBankAccountService bankAccountService;

    public AccountRestController(IBankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping({"", "/"})
    public List<BankAccountDTO> getAllAccounts() {
        return bankAccountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public BankAccountDTO getAccountById(@PathVariable String id) {
        return bankAccountService.getAccountById(id);
    }

    @PostMapping({"", "/"})
    public BankAccountDTO saveAccount(@RequestBody BankAccountDTO account) {
        return bankAccountService.saveAccount(account);
    }

    @PutMapping({"", "/"})
    public BankAccountDTO updateAccount(@RequestBody BankAccountDTO account) {
        return bankAccountService.updateAccount(account);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable String id) {
        bankAccountService.deleteAccount(id);
    }

}
