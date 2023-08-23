package com.ahmetyildiran.enoca.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeSaveRequest {

    private String name;
    private String surname;
    private String email;
    private CompanyDto companyDto;



}
