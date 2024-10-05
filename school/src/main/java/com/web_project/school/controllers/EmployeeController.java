package com.web_project.school.controllers;

import com.web_project.school.model.EmployeeModel;
import com.web_project.school.model.StudentModel;
import com.web_project.school.service.EmployeeService;
import com.web_project.school.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;

    @GetMapping("/all")
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.findAllEmployees());
        model.addAttribute("employee", new EmployeeModel());
        return "employeeList";
    }

    @PostMapping("/add")
    public String addEmployee(@Valid @ModelAttribute("employee") EmployeeModel employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("employees", employeeService.findAllEmployees());
            return "employeeList";
        }
        employeeService.addEmployee(employee);
        return "redirect:/employees/all";
    }

    @PostMapping("/update")
    public String updateEmployee(@Valid @ModelAttribute("employee") EmployeeModel employee, BindingResult result) {
        employeeService.updateEmployee(employee);
        return "redirect:/employees/all";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees/all";
    }

    @GetMapping("/all/{id}")
    public String getEmployeeById(@PathVariable("id") Long id, Model model) {
        EmployeeModel employee = employeeService.findEmployeeById(id);
        if (employee != null) {
            model.addAttribute("employee", employee);
            return "employeeList";
        } else {
            return "redirect:/employees/all";
        }
    }

    @GetMapping("/search")
    public String searchEmployees(@RequestParam String value, Model model) {
        List<EmployeeModel> employees = employeeService.searchByAnyField(value);
        model.addAttribute("employees", employees);
        return "searchResults";
    }

    @PostMapping("/logicalDelete")
    public String logicalDeleteEmployee(@RequestParam Long id) {
        employeeService.logicalDeleteEmployee(id);
        return "redirect:/employees/all";
    }
}