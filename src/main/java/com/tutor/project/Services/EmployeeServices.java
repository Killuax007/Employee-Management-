package com.tutor.project.Services;

import com.tutor.project.Entity.Employee;
import com.tutor.project.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class EmployeeServices {
    @Autowired
    private EmployeeRepo employeeRepo;
    public List<Employee> getAll() {
        List<Employee> list =(List<Employee>)this.employeeRepo.findAll();
        return list;

    }
    public Employee getEmployeeById(long id) {
        return  employeeRepo.findById(id);
    }
    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
    public void deleteEmployee(String id) {
         employeeRepo.deleteById(id);
    }


}
