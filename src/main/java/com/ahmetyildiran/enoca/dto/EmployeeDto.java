package com.ahmetyildiran.enoca.dto;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class EmployeeDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private CompanyDto companyDto;

}
