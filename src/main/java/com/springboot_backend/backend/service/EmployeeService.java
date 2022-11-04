package com.springboot_backend.backend.service;

import com.springboot_backend.backend.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    // to get all emp data
    List<Employee> getAllEmployess();

    // to get all emp by id
    Employee getEmployeeByID(long id);

    // update emp
    Employee updateEmployee(Employee employee, long id);

    // delete emp , not need to return for deletion
    void deleteEmployee(long id);
    
}
