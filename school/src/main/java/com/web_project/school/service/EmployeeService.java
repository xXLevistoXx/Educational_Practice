package com.web_project.school.service;

import com.web_project.school.model.EmployeeModel;
import com.web_project.school.model.StudentModel;

import java.util.List;
import java.util.Set;

public interface EmployeeService {
    public List<EmployeeModel> findAllEmployees();

    public EmployeeModel findEmployeeById(Long id);

    public EmployeeModel addEmployee(EmployeeModel employee);

    public EmployeeModel updateEmployee(EmployeeModel employee);

    public void deleteEmployee(Long id);


    public List<EmployeeModel> searchByAnyField(String value);


    public void logicalDeleteEmployee(Long id);

}