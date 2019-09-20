package com.systango.springboard.domain.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.systango.springboard.domain.model.BaseDomainObject;
import com.systango.springboard.domain.model.payment.WalletDetails;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Arpit Khandelwal.
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties (ignoreUnknown=true)
@Entity
public class ApplicationUser extends BaseDomainObject {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "applicationUser")
    private WalletDetails walletDetails;
}
