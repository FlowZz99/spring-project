package it.flowzz.spring.api.dao;

import it.flowzz.spring.api.model.SubAccount;
import it.flowzz.spring.api.model.ids.SubAccountId;
import org.springframework.data.repository.CrudRepository;

public interface SubAccountDao extends CrudRepository<SubAccount, SubAccountId> {


}
