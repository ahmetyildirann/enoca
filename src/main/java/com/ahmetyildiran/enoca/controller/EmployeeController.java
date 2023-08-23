package com.ahmetyildiran.enoca.controller;

import com.ahmetyildiran.enoca.dto.EmployeeDto;
import com.ahmetyildiran.enoca.dto.EmployeeSaveRequest;
import com.ahmetyildiran.enoca.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> save(@RequestBody EmployeeSaveRequest employeeSaveRequest){
        EmployeeDto employeeDto = employeeService.save(employeeSaveRequest);
        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> findAll(){
        List<EmployeeDto> employeeDtoList = employeeService.findAll();
        return ResponseEntity.ok(employeeDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> findById(@PathVariable Long id){
        EmployeeDto employeeDto = employeeService.findById(id);
        return ResponseEntity.ok(employeeDto);
    }

    @PutMapping()
    public ResponseEntity<EmployeeDto> update( @RequestBody EmployeeDto employeeDto){
        employeeService.update(employeeDto);
        return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        employeeService.delete(id);
        return ResponseEntity.ok().build();
    }


}
