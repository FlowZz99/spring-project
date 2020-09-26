package it.flowzz.spring.api.model;


import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(name = "id",length = 36)
    private UUID id;
    @NonNull private String owner;
    private AccountType type = AccountType.PRIVATE;
    private int balance;

    @OneToMany(mappedBy = "accountId", cascade = CascadeType.ALL)
    private Set<SubAccount> allowedUsers;


    public enum AccountType{
        BUSINESS,
        PRIVATE
    }
}
