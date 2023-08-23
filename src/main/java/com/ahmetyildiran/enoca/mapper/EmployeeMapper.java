package com.ahmetyildiran.enoca.mapper;

import com.ahmetyildiran.enoca.dto.EmployeeDto;
import com.ahmetyildiran.enoca.dto.EmployeeSaveRequest;
import com.ahmetyildiran.enoca.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMapper {

    public static Employee convertEmployee(EmployeeDto employeeDto){
        Employee entity = null;
        if(employeeDto != null){
            entity = new Employee();
            entity.setId(employeeDto.getId());
            entity.setName(employeeDto.getName());
            entity.setSurname(employeeDto.getSurname());
            entity.setEmail(employeeDto.getEmail());
            entity.setCompany(CompanyMapper.convertCompany(employeeDto.getCompanyDto()));
        }
        return entity;

    }

    public static Employee convertRequestToEmployee(EmployeeSaveRequest employeeSaveRequest){
        Employee entity = null;
        if(employeeSaveRequest != null){
            entity = new Employee();
            entity.setSurname(employeeSaveRequest.getSurname());
            entity.setEmail(employeeSaveRequest.getEmail());
            entity.setName(employeeSaveRequest.getName());
            entity.setCompany(CompanyMapper.convertCompany(employeeSaveRequest.getCompanyDto()));
        }
        return entity;

    }



    public static EmployeeDto convertEmployeeDto(Employee employee){
        EmployeeDto dto = null;
        if(employee != null){
            dto = new EmployeeDto();
            dto.setId(employee.getId());
            dto.setName(employee.getName());
            dto.setSurname(employee.getSurname());
            dto.setEmail(employee.getEmail());
            dto.setCompanyDto(CompanyMapper.convertCompanyDto(employee.getCompany()));
        }
        return dto;

    }

    public static List<Employee> convertEntityList(List<EmployeeDto> dtoList){
        List<Employee> mappedList = new ArrayList<>();
        Employee entity;
        if (dtoList != null){
            for (EmployeeDto dto : dtoList){
                entity = convertEmployee(dto);
                mappedList.add(entity);
            }
        }
        return mappedList;
    }

    public static List<EmployeeDto> convertDtoList(List<Employee> entityList){
        List<EmployeeDto> mappedList = new ArrayList<>();
        EmployeeDto dto;
        if (entityList != null){
            for (Employee entity : entityList){
                dto = convertEmployeeDto(entity);
                mappedList.add(dto);
            }
        }
        return mappedList;
    }
}
