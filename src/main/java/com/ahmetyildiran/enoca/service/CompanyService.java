package com.ahmetyildiran.enoca.service;

import com.ahmetyildiran.enoca.dto.CompanyDto;
import com.ahmetyildiran.enoca.dto.CompanySaveRequest;
import com.ahmetyildiran.enoca.mapper.CompanyMapper;
import com.ahmetyildiran.enoca.model.Company;
import com.ahmetyildiran.enoca.service.entityService.CompanyEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

  private final CompanyEntityService companyEntityService;

    public CompanyDto save(CompanySaveRequest request) {
        Company company = CompanyMapper.convertRequestToCompany(request);
        company = companyEntityService.save(company);

        CompanyDto companyDto = CompanyMapper.convertCompanyDto(company);
        return companyDto;
    }

    public List<CompanyDto> findAll() {

        List<Company> companyList = companyEntityService.findAll();
        if (companyList.isEmpty()){
            throw new IllegalStateException("Company list is empty");
        }
        return CompanyMapper.convertDtoList(companyList);

    }


    public CompanyDto findById(Long id) {
        Company company = companyEntityService.findByIdWithControl(id);
        if (company.getId() == null){
            throw new IllegalStateException("Company not found with id " + id);
        }
        CompanyDto companyDto = CompanyMapper.convertCompanyDto(company);
        return companyDto;
    }


    public void delete(Long id) {
        boolean exist = companyEntityService.isExist(id);
        if (!exist){
            throw new IllegalStateException("Company not found with id " + id);
        }
        companyEntityService.delete(id);
    }





    public CompanyDto update(CompanyDto companyDto) {
        boolean exist = companyEntityService.isExist(companyDto.getId());
        if (!exist){
            throw new IllegalStateException("Company not found with id " + companyDto.getId());
        }
        Company company = CompanyMapper.convertCompany(companyDto);
        company = companyEntityService.save(company);
        return CompanyMapper.convertCompanyDto(company);

    }


    }


