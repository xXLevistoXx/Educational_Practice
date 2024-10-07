package com.web_project.school.service;

import com.web_project.school.model.EmployeeModel;
import com.web_project.school.repository.EmployeeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InMemoryEmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public InMemoryEmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeModel> findAllEmployees() {
        return employeeRepository.findAllActive();
    }

    @Override
    public EmployeeModel findEmployeeById(UUID id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public EmployeeModel addEmployee(EmployeeModel employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public EmployeeModel updateEmployee(EmployeeModel employee) {
        if (employeeRepository.existsById(employee.getId())) {
            return employeeRepository.save(employee);
        }
        return null;
    }

    @Override
    public void deleteEmployee(UUID id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        }
    }

    @Override
    public List<EmployeeModel> searchByAnyField(String value) {
        return employeeRepository.searchByAnyField(value);
    }

    @Override
    public void logicalDeleteEmployee(UUID id) {
        Optional<EmployeeModel> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            EmployeeModel employee = employeeOptional.get();
            employee.setDeleted(true);
            employeeRepository.save(employee);
        }
    }
}