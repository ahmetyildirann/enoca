package com.ahmetyildiran.enoca.service.entityService;

import com.ahmetyildiran.enoca.general.BaseEntityService;
import com.ahmetyildiran.enoca.model.Employee;
import com.ahmetyildiran.enoca.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeEntityService extends BaseEntityService<Employee, EmployeeRepository> {

    public EmployeeEntityService(EmployeeRepository repository) {
        super(repository);
    }
}
