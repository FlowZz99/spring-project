package it.flowzz.spring.api.service;


import it.flowzz.spring.api.dao.AccountDao;
import it.flowzz.spring.api.dao.SubAccountDao;
import it.flowzz.spring.api.model.Account;
import it.flowzz.spring.api.model.SubAccount;
import it.flowzz.spring.api.model.ids.SubAccountId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AccountServiceProvider {

    private final AccountDao accountDao;
    private final SubAccountDao subAccountDao;

    @Autowired
    public AccountServiceProvider(AccountDao accountDao, SubAccountDao subAccountDao) {
        this.accountDao = accountDao;
        this.subAccountDao = subAccountDao;
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

    public void deleteSubAccountById(UUID accountId, UUID id) {
        subAccountDao.deleteById(new SubAccountId(accountId,id));
    }

    public void addSubAccount(SubAccount subAccount) {
        subAccountDao.save(subAccount);
    }

}
