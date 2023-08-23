package com.ahmetyildiran.enoca.service;

import com.ahmetyildiran.enoca.dto.EmployeeDto;
import com.ahmetyildiran.enoca.dto.EmployeeSaveRequest;
import com.ahmetyildiran.enoca.mapper.EmployeeMapper;
import com.ahmetyildiran.enoca.model.Employee;
import com.ahmetyildiran.enoca.service.entityService.EmployeeEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeEntityService employeeEntityService;
    public EmployeeDto save(EmployeeSaveRequest employeeSaveRequest) {
        log.info("EmployeeEntityService::save|employeeSaveRequest"+employeeSaveRequest);
        Employee employee = EmployeeMapper.convertRequestToEmployee(employeeSaveRequest);
        employee = employeeEntityService.save(employee);

        EmployeeDto employeeDto = EmployeeMapper.convertEmployeeDto(employee);
        return employeeDto;

    }

    public List<EmployeeDto> findAll() {
        List<Employee> employeeList = employeeEntityService.findAll();
        log.info("EmployeeEntityService::findAll|employeeList"+employeeList);
        if (employeeList.isEmpty()) {
            throw new IllegalStateException("Employee list is empty");
        }
        return EmployeeMapper.convertDtoList(employeeList);

    }

    public EmployeeDto findById(Long id) {
        log.info("EmployeeEntityService::findById|id"+id);
        Employee employee = employeeEntityService.findByIdWithControl(id);
        EmployeeDto employeeDto = EmployeeMapper.convertEmployeeDto(employee);
        return employeeDto;
    }


    public void delete(Long id) {
        log.info("EmployeeEntityService::delete|id"+id);
        boolean exist = employeeEntityService.isExist(id);
        if (!exist) {
            throw new IllegalStateException("Employee not found with id " + id);
        }
        employeeEntityService.delete(id);

    }

    public EmployeeDto update(EmployeeDto employeeDto) {
        log.info("EmployeeEntityService::update|employeeDto"+employeeDto);
        boolean exist = employeeEntityService.isExist(employeeDto.getId());
        if (!exist) {
            throw new IllegalStateException("Employee not found");
        }
        Employee employee = EmployeeMapper.convertEmployee(employeeDto);
        employee = employeeEntityService.save(employee);

        return EmployeeMapper.convertEmployeeDto(employee);
    }
}