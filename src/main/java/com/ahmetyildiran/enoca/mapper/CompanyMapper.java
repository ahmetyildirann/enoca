package com.ahmetyildiran.enoca.mapper;

import com.ahmetyildiran.enoca.dto.CompanyDto;
import com.ahmetyildiran.enoca.dto.CompanySaveRequest;
import com.ahmetyildiran.enoca.model.Company;

import java.util.ArrayList;
import java.util.List;

public class CompanyMapper {

    public static Company convertCompany(CompanyDto companyDto) {
        Company entity = null;
        if (companyDto != null) {
            entity = new Company();
            entity.setId(companyDto.getId());
            entity.setName(companyDto.getName());
            entity.setAddress(companyDto.getAddress());
            entity.setEmail(companyDto.getEmail());
        }
        return entity;

    }

    public static Company convertRequestToCompany(CompanySaveRequest companySaveRequest) {
        Company entity = null;
        if (companySaveRequest != null) {
            entity = new Company();
            entity.setName(companySaveRequest.getName());
            entity.setAddress(companySaveRequest.getAddress());
            entity.setEmail(companySaveRequest.getEmail());
        }
        return entity;
    }

    public static CompanyDto convertCompanyDto(Company company) {
        CompanyDto dto = null;
        if (company != null) {
            dto = new CompanyDto();
            dto.setId(company.getId());
            dto.setName(company.getName());
            dto.setAddress(company.getAddress());
            dto.setEmail(company.getEmail());
        }
        return dto;

    }

    public static List<Company> convertEntityList(List<CompanyDto> dtoList) {
        List<Company> mappedList = new ArrayList<>();
        Company entity;
        if (dtoList != null) {
            for (CompanyDto dto : dtoList) {
                entity = convertCompany(dto);
                mappedList.add(entity);
            }
        }
        return mappedList;

    }

    public static List<CompanyDto> convertDtoList(List<Company> entityList) {
        List<CompanyDto> mappedList = new ArrayList<>();
        CompanyDto dto;
        if (entityList != null) {
            for (Company entity : entityList) {
                dto = convertCompanyDto(entity);
                mappedList.add(dto);
            }
        }
        return mappedList;

    }


}