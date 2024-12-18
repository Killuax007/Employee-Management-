package com.tutor.project.Repository;

import com.tutor.project.Entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<Employee,String> {
    public Employee findById(long id);


}
