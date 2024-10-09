package com.web_project.school.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER', 'USER')")
public class UserController {

    @GetMapping("/dashboard")
    public String userDashboard() {
        return "userDashboard";
    }
}
