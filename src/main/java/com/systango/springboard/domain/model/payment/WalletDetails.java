package com.systango.springboard.domain.model.payment;

import com.systango.springboard.domain.model.BaseDomainObject;
import com.systango.springboard.domain.model.user.ApplicationUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Arpit Khandelwal.
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class WalletDetails extends BaseDomainObject {

    @Transient
    private BigDecimal balance;

    @Column
    @Enumerated(EnumType.STRING)
    private WalletLevel walletLevel;
    
    @OneToOne
    private ApplicationUser applicationUser;

}
