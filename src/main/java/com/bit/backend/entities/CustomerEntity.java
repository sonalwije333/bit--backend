package com.bit.backend.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String  lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private String  gender;

    @Column(name = "email")
    private String  email;

    @Column(name = "phoneNumber")
    private String  phoneNumber;

    @Column(name = "address")
    private String  address;

}
