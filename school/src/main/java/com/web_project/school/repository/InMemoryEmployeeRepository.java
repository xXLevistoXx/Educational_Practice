//package com.web_project.school.repository;
//
//import com.web_project.school.model.EmployeeModel;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.stream.Collectors;
//
//@Repository
//public class InMemoryEmployeeRepository {
//    private List<EmployeeModel> employees = new ArrayList<>();
//    private AtomicInteger idCounter = new AtomicInteger(1);
//
//    public List<EmployeeModel> findAllEmployees() {
//        return employees.stream()
//                .filter(employee -> !employee.isDeleted())
//                .collect(Collectors.toList());
//    }
//
//    public EmployeeModel addEmployee(EmployeeModel employee) {
//        employee.setId(idCounter.getAndIncrement());
//        employees.add(employee);
//        return employee;
//    }
//
//    public void deleteEmployee(int id) {
//        employees.removeIf(employee -> employee.getId() == id);
//    }
//
//    public EmployeeModel updateEmployee(EmployeeModel employee) {
//        for (int i = 0; i < employees.size(); i++) {
//            if (employees.get(i).getId() == employee.getId()) {
//                employees.set(i, employee);
//                return employee;
//            }
//        }
//        return null;
//    }
//
//    public EmployeeModel findEmployeeById(int id) {
//        return employees.stream().filter(employee -> employee.getId() == id)
//                .findFirst().orElse(null);
//    }
//
//    // Логическое удаление
//    public void logicalDeleteEmployee(int id) {
//        employees.stream()
//                .filter(employee -> employee.getId() == id)
//                .findFirst()
//                .ifPresent(employee -> employee.setDeleted(true));
//    }
//
//    // Поиск по имени
//    public List<EmployeeModel> searchEmployeesByName(String name) {
//        return employees.stream()
//                .filter(employee -> employee.getName().equalsIgnoreCase(name))
//                .collect(Collectors.toList());
//    }
//
//    // Фильтрация по алфавиту
//    public List<EmployeeModel> filterEmployeesByAlphabet() {
//        return employees.stream()
//                .sorted((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()))
//                .collect(Collectors.toList());
//    }
//
//    // Фильтрация по новизне добавления
//    public List<EmployeeModel> filterEmployeesByNewest() {
//        return employees.stream()
//                .sorted((e1, e2) -> Integer.compare(e2.getId(), e1.getId()))
//                .collect(Collectors.toList());
//    }
//}