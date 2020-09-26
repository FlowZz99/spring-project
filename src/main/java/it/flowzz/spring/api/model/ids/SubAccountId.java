package it.flowzz.spring.api.model.ids;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class SubAccountId implements Serializable {

    private UUID accountId;
    private UUID uuid;
}
