package com.web_project.school.service;

import com.web_project.school.model.EmployeeModel;
import com.web_project.school.model.StudentModel;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface EmployeeService {
    public List<EmployeeModel> findAllEmployees();

    public EmployeeModel findEmployeeById(UUID id);

    public EmployeeModel addEmployee(EmployeeModel employee);

    public EmployeeModel updateEmployee(EmployeeModel employee);

    public void deleteEmployee(UUID id);


    public List<EmployeeModel> searchByAnyField(String value);


    public void logicalDeleteEmployee(UUID id);

}