package com.controller;

import com.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.services.EmpServices;

@RestController
@RequestMapping("/api/crud/employee")
public class EmpController {

    @Autowired
    private EmpServices empServ;

    @RequestMapping(value = "/addemployee", method = RequestMethod.POST)
    public String addEmployee(@RequestBody Employee emp) {
        try {
            empServ.addEmployee(emp);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return "Employee Added Successfully";
    }


    @RequestMapping(value = "/updateEmployeeById/{id}/{salary}", method = RequestMethod.PUT)
    public String updateEmployee(@PathVariable("id") long id, @PathVariable("salary") int salary) {
        try {
            empServ.updateEmployeeById(id, salary);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return "Employee updated Successfully";
    }


    @RequestMapping(value = "/deleteemployee/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") long id) {
        try {
            empServ.deleteEmployeeById(id);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return "Employee deleted Successfully";
    }


    @RequestMapping(value = "/getEmployeeById/{id}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable("id") long id) {
        Employee emp = null;
        try {
            emp = empServ.getEmployeeById(id);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return emp;
    }


}
