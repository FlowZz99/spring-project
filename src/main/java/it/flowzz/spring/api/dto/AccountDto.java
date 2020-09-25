package it.flowzz.spring.api.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import it.flowzz.spring.api.model.Account;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "sub_accounts")
public class AccountDto implements Serializable {


    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private Account accountId;

    @Id
    @Column(length = 36)
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID uuid;
    private String name;



}
