package com.ahmetyildiran.enoca.model;

import com.ahmetyildiran.enoca.general.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "company")
@Getter
@Setter
public class Company extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "comp_id")
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "address", length = 100, nullable = false)
    private String address;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @OneToMany(mappedBy = "company")
    private List<Employee> employees;



}
