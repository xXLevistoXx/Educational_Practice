package com.web_project.school.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
@PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
public class ManagerController {

    @GetMapping("/dashboard")
    public String managerDashboard() {
        return "managerDashboard";
    }
}
