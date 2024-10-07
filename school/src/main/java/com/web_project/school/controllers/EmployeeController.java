package com.web_project.school.controllers;

import com.web_project.school.model.EmployeeModel;
import com.web_project.school.model.PositionModel;
import com.web_project.school.service.EmployeeService;
import com.web_project.school.service.SubjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;
    @Autowired
    public SubjectService subjectService;

    @GetMapping("/all")
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.findAllEmployees());
        model.addAttribute("employee", new EmployeeModel());
        model.addAttribute("subjects", subjectService.findAllSubjects());
        return "employeeList";
    }

    @PostMapping("/add")
    public String addEmployee(@Valid @ModelAttribute("employee") EmployeeModel employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("employees", employeeService.findAllEmployees());
            model.addAttribute("subjects", subjectService.findAllSubjects());
            return "employeeList";
        }
        PositionModel position = employee.getPosition();
        employee.setPosition(position);
        employeeService.addEmployee(employee);
        return "redirect:/employees/all";
    }

    @PostMapping("/update")
    public String updateEmployee(@Valid @ModelAttribute("employee") EmployeeModel employee, BindingResult result) {
        employeeService.updateEmployee(employee);
        return "redirect:/employees/all";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam UUID id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees/all";
    }

    @GetMapping("/all/{id}")
    public String getEmployeeById(@PathVariable("id") UUID id, Model model) {
        EmployeeModel employee = employeeService.findEmployeeById(id);
        if (employee != null) {
            model.addAttribute("employee", employee);
            model.addAttribute("subjects", subjectService.findAllSubjects());
            return "employeeList";
        } else {
            return "redirect:/employees/all";
        }
    }

    @GetMapping("/search")
    public String searchEmployees(@RequestParam String value, Model model) {
        List<EmployeeModel> employees = employeeService.searchByAnyField(value);
        model.addAttribute("employees", employees);
        model.addAttribute("subjects", subjectService.findAllSubjects());
        return "searchResults";
    }

    @PostMapping("/logicalDelete")
    public String logicalDeleteEmployee(@RequestParam UUID id) {
        employeeService.logicalDeleteEmployee(id);
        return "redirect:/employees/all";
    }
}