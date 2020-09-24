package it.flowzz.spring.api.dao;

import it.flowzz.spring.api.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AccountDao extends CrudRepository<Account, UUID> {

}
