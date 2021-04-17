package com.springmongoprg.speingmongoproject.controller;

import com.springmongoprg.speingmongoproject.model.Employee;
import com.springmongoprg.speingmongoproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/saveEmployee")
    public String addEmployee(@RequestBody Employee employee){
        employeeRepository.save(employee);
        return "Employee added";
    }

    @GetMapping("/getEmployees")
    public List<Employee> getEmployeeList(){
        return employeeRepository.findAll();
    }

    @GetMapping("/search/{searchString}")
    public List<Employee> searchEmp(@PathVariable String searchString){
        return employeeRepository.searchEmployee(searchString);
    }

}
