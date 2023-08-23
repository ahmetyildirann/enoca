package com.ahmetyildiran.enoca.model;

import com.ahmetyildiran.enoca.general.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "surname", length = 100, nullable = false)
    private String surname;


    @Column(name = "email", length = 100, nullable = false)
    private String email;


    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "comp_id", nullable = false)
    private Company company;



}
