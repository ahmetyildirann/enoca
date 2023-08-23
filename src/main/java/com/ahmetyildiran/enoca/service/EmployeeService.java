package com.ahmetyildiran.enoca.service;

import com.ahmetyildiran.enoca.dto.EmployeeDto;
import com.ahmetyildiran.enoca.dto.EmployeeSaveRequest;
import com.ahmetyildiran.enoca.mapper.EmployeeMapper;
import com.ahmetyildiran.enoca.model.Employee;
import com.ahmetyildiran.enoca.service.entityService.EmployeeEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeEntityService employeeEntityService;
    public EmployeeDto save(EmployeeSaveRequest employeeSaveRequest) {
        Employee employee = EmployeeMapper.convertRequestToEmployee(employeeSaveRequest);
        employee = employeeEntityService.save(employee);

        EmployeeDto employeeDto = EmployeeMapper.convertEmployeeDto(employee);
        return employeeDto;

    }

    public List<EmployeeDto> findAll() {
        List<Employee> employeeList = employeeEntityService.findAll();
        if (employeeList.isEmpty()) {
            throw new IllegalStateException("Employee list is empty");
        }
        return EmployeeMapper.convertDtoList(employeeList);

    }

    public EmployeeDto findById(Long id) {
        Employee employee = employeeEntityService.findByIdWithControl(id);
        EmployeeDto employeeDto = EmployeeMapper.convertEmployeeDto(employee);
        return employeeDto;
    }


    public void delete(Long id) {
        boolean exist = employeeEntityService.isExist(id);
        if (!exist) {
            throw new IllegalStateException("Employee not found with id " + id);
        }
        employeeEntityService.delete(id);

    }

    public EmployeeDto update(EmployeeDto employeeDto) {
        boolean exist = employeeEntityService.isExist(employeeDto.getId());
        if (!exist) {
            throw new IllegalStateException("Employee not found");
        }
        Employee employee = EmployeeMapper.convertEmployee(employeeDto);
        employee = employeeEntityService.save(employee);

        return EmployeeMapper.convertEmployeeDto(employee);
    }
}