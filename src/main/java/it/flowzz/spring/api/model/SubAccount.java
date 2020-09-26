package it.flowzz.spring.api.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import it.flowzz.spring.api.model.ids.SubAccountId;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "sub_accounts")
@IdClass(SubAccountId.class)
public class SubAccount {

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "account_id")
    transient private Account account;

    @Id
    @Column(length = 36)
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID uuid;
    @Id
    @Column(length = 36)
    @Type(type="org.hibernate.type.UUIDCharType")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UUID accountId;
    @Column(updatable = false)
    private String name;



}
