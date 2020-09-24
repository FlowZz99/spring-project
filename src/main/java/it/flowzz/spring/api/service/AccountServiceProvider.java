package it.flowzz.spring.api.service;


import it.flowzz.spring.api.dao.AccountDao;
import it.flowzz.spring.api.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AccountServiceProvider {

    private final AccountDao accountDao;

    @Autowired
    public AccountServiceProvider(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Iterable<Account> getAccounts() {
        return accountDao.findAll();
    }

    public void updateAccountById(UUID id, Account account){
        accountDao.deleteById(id);
        accountDao.save(account);
    }

    public Optional<Account> getAccountById(UUID id){
        return accountDao.findById(id);
    }

    public void deleteAccountById(UUID id){
        accountDao.deleteById(id);
    }

    public void addAccount(Account account) {
        accountDao.save(account);
    }

}
