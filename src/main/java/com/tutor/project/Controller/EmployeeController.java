package com.tutor.project.Controller;

import com.tutor.project.Entity.Employee;
import com.tutor.project.Services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeServices employeeService;

    @GetMapping
    public  List<Employee> getAllEmployees(){
        List<Employee> employees=employeeService.getAll();
        return employees;
    }
    @GetMapping("/{empId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long empId){
        Employee emp=employeeService.getEmployeeById(empId);
        if (emp==null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Employee> addEmployees(@RequestBody Employee employee){
        if(employee.getName()!=null && employee.getSalary()!=null && employee.getDepartment()!=null && employee.getEmail()!=null) {
            Employee emp=this.employeeService.addEmployee(employee);
            System.out.println(emp.toString());
            return  new ResponseEntity<>(emp,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @PutMapping("/{empId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long empId,@RequestBody Employee employee){
        try{
            Employee oldInfo=employeeService.getEmployeeById(empId);
            System.out.println(oldInfo.toString());
            System.out.println(employee.toString());
            if(oldInfo!=null){
                oldInfo.setName(employee.getName() != null && !employee.getName().equals("") ? employee.getName() : oldInfo.getName());
                oldInfo.setDepartment(employee.getDepartment() != null && !employee.getDepartment().equals("") ? employee.getDepartment() : oldInfo.getDepartment());
                oldInfo.setEmail(employee.getEmail() != null && !employee.getEmail().equals("") ? employee.getEmail() : oldInfo.getEmail());
                oldInfo.setSalary(employee.getSalary() != null && !employee.getSalary().equals("") ? employee.getSalary() : oldInfo.getSalary());
            }
            employeeService.addEmployee(oldInfo);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
    @DeleteMapping("/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String empId){
        employeeService.deleteEmployee(empId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }
}
