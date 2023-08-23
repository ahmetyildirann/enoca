package com.ahmetyildiran.enoca.service.entityService;

import com.ahmetyildiran.enoca.general.BaseEntityService;
import com.ahmetyildiran.enoca.model.Company;
import com.ahmetyildiran.enoca.repository.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyEntityService extends BaseEntityService<Company, CompanyRepository> {


    public CompanyEntityService(CompanyRepository repository) {
        super(repository);
    }
}
