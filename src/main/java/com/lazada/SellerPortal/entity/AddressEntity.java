package com.lazada.SellerPortal.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "address")
public class AddressEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column
    private long id;

    @Column
    private String line1;

    @Column
    private String line2;

    @Column
    private String city;

    @Column
    private String postCode;

    @Column
    private String country;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity userEntity;
}
