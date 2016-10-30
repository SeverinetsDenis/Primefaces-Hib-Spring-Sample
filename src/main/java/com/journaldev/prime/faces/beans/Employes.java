package com.journaldev.prime.faces.beans;

import com.journaldev.hibernate.data.Employee;
import com.journaldev.spring.service.EmployeeService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by DENIS on 30.10.2016.
 */
@ManagedBean
@RequestScoped
public class Employes {

    @ManagedProperty("#{employeeService}")
    private EmployeeService employeeService;

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //Some actions will be executed before creating a JSF page and each time after reload page
    @PostConstruct
    public void init (){
    }

    public List<Employee> getEmployes() {
        return employeeService.getEmployes();
    }
}
