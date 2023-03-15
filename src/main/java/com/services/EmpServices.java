package com.services;

import com.exception.custException;
import com.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.EmployeeRepo;

import java.util.Optional;

@Service
public class EmpServices {
    @Autowired
    private EmployeeRepo empRepo;

    public Employee addEmployee(Employee emp)throws custException
    {
        Optional<Employee> opt = this.empRepo.findById((long) emp.getId());
        if(opt.isPresent()) {
            throw new custException("Employee Already Exits.......");
        }
        empRepo.save(emp);
        return emp;
    }


    public Employee getEmployeeById(long id)throws custException
    {
        Employee emp = null;
        Optional<Employee> opt = this.empRepo.findById((long) id);
        if(opt.isPresent()) {
            emp = opt.get();

        }
        else{
            throw new custException("Employee not found.....");
        }

        return emp;
    }


    public boolean deleteEmployeeById(long id)throws custException
    {
        boolean status = false;
        Optional<Employee> opt = this.empRepo.findById((long) id);
        if(opt.isPresent()) {
            Employee emp = opt.get();
            empRepo.delete(emp);
            status = true;
        }
        else{
            throw new custException("Employee does not exists......");
        }

        return status;
    }


    public boolean updateEmployeeById(long id, int salary)throws custException
    {
        empRepo.updateEmployeeById(id, salary);
        return true;
    }
}
