package com.psb.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String companyName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    @Column
    private String website;

    @Column
    private String registrationNumber;

    @Column
    private String companyType;

    @Column(length = 2000)
    private String description;

    public Company(String companyName, String address, String city, String state,
                  String country, String phone, String email, String website,
                  String registrationNumber, String companyType, String description) {
        this.companyName = companyName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.phone = phone;
        this.email = email;
        this.website = website;
        this.registrationNumber = registrationNumber;
        this.companyType = companyType;
        this.description = description;
    }
}
