package com.lazada.SellerPortal.entity;

import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column
    private long id;

    @Column(name = "user_id")
    private String userId;

    @Column
    private int accountType;

    @Column
    private String shopBased;

    @Column
    private String mobileNumber;

    @Column
    private String email;

    @Column
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userEntity")
    private List<AddressEntity> addressEntities;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userEntity")
    private List<IdentityEntity> identityEntities;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userEntity")
    private List<BankEntity> bankEntities;

}
