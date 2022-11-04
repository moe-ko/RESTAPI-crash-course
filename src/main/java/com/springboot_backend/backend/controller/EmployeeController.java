package com.springboot_backend.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot_backend.backend.model.Employee;
import com.springboot_backend.backend.service.EmployeeService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController // eliminates d need of @Controller n @ResponseBody
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    

    // build create employee REST API
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
    {
         return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }


    // build get all emp REST API
    @GetMapping
    public List<Employee> getAllEmployees()
    {
        return employeeService.getAllEmployess();
    }


    // build get emp by id REST API
    @GetMapping("{id}") // with path variable
    public ResponseEntity<Employee> getEmployeeById(@PathVariable ("id") long id)   // for path variable
    {
        return new ResponseEntity<Employee>(employeeService.getEmployeeByID(id), HttpStatus.OK);
    }

    
    // build update emp REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,
                                                    @RequestBody Employee employee  // to store and update the data json to java
                                                  )
    {
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }


    // build delete emp REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id)
    {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);
    }
}
