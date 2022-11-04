package com.springboot_backend.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot_backend.backend.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}
