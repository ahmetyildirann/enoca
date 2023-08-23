package com.ahmetyildiran.enoca.repository;

import com.ahmetyildiran.enoca.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
