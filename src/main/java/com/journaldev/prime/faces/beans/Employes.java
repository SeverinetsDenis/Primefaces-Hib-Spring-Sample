package com.journaldev.prime.faces.beans;

import com.journaldev.hibernate.data.Employee;
import com.journaldev.spring.service.EmployeeService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.List;

/**
 * Created by DENIS on 30.10.2016.
 */
@ManagedBean
@RequestScoped
public class Employes {

    private List<Employee> employes;

    @ManagedProperty("#{employeeService}")
    private EmployeeService employeeService;

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostConstruct
    public void init (){
        //Some actions will be applied each time after reload page

    }

    public List<Employee> getEmployes() {
        employes = employeeService.getEmployes();
        return employes;
    }
}
