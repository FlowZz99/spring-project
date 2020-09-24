package it.flowzz.spring.api.controller;

import it.flowzz.spring.api.model.Account;
import it.flowzz.spring.api.service.AccountServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/account")
public class AccountController {

    private final AccountServiceProvider accountServiceProvider;

    @Autowired
    public AccountController(AccountServiceProvider accountServiceProvider) {
        this.accountServiceProvider = accountServiceProvider;
    }

    @GetMapping
    public List<Account> getAccounts() {
        return (List<Account>) accountServiceProvider.getAccounts();
    }

    @GetMapping(path = "{id}")
    public Account getAccountById(@PathVariable("id") UUID id) { return accountServiceProvider.getAccountById(id).orElse(null); }
    @PostMapping
    public void addAccount(@RequestBody Account account) {
        accountServiceProvider.addAccount(account);
    }

    @DeleteMapping(path = "{id}")
    public void deleteAccountById(@PathVariable("id") UUID id) {
        accountServiceProvider.deleteAccountById(id);
    }

    @PutMapping(path = "{id}")
    public void updateAccountById(@PathVariable("id") UUID id, @RequestBody Account account){
        accountServiceProvider.updateAccountById(id, account);
    }

}
