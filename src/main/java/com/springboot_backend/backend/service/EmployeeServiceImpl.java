package com.springboot_backend.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot_backend.backend.exception.ResourceNotFoundException;
import com.springboot_backend.backend.model.Employee;
import com.springboot_backend.backend.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
    

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


    @Override
    public List<Employee> getAllEmployess() {
        return employeeRepository.findAll();
    }


    @Override
    public Employee getEmployeeByID(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        // in lambda
        return employeeRepository.findById(id).orElseThrow(() -> 
                                        new ResourceNotFoundException("Employee", "id", id));

        // if (employee.isPresent()) {
        //     return employee.get();
        // }
        // else
        // {
        //     throw new ResourceNotFoundException("Employee", "id", id);
        // }
    }


    @Override
    public Employee updateEmployee(Employee employee, long id) {
        // checking emp is in db
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                                    () -> new ResourceNotFoundException("Employee", "id", id));
        
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }


    @Override
    public void deleteEmployee(long id) {
        // checking emp is in db
        employeeRepository.findById(id).orElseThrow(
                                    () -> new ResourceNotFoundException("Employee", "id", id));
        employeeRepository.deleteById(id);
    }
}
