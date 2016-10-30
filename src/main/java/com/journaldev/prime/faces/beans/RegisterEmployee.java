package com.journaldev.prime.faces.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.journaldev.hibernate.data.Employee;
import com.journaldev.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@ManagedBean
@SessionScoped
public class RegisterEmployee implements Serializable {

	@ManagedProperty("#{employeeService}")
	private EmployeeService employeeService;
	@ManagedProperty("#{employee}")
	private Employee employee;

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String register() {
		// Calling Business Service
		employeeService.register(employee);
		// Add message
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("The Employee "+this.employee.getEmployeeName()+" Is Registered Successfully"));
		return "";
	}

    public String goToEmployesPage(){
        return "pages/allEmployes.xhtml?faces-redirect=true&includeViewParams=true";
    }
}
