package com.lazada.SellerPortal.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "bank")
public class BankEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column
    private long id;

    @Column
    private String accountName;

    @Column
    private String accountNumber;

    @Column
    private String bankName;

    @Column
    private String code;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity userEntity;
}
