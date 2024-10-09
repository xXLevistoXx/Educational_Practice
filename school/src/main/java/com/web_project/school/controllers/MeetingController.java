package com.web_project.school.controllers;

import com.web_project.school.model.MeetingModel;
import com.web_project.school.service.EmployeeService;
import com.web_project.school.service.MeetingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@Controller
@RequestMapping("/meetings")
@PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER', 'USER')")
public class MeetingController {
    @Autowired
    public MeetingService meetingService;

    @Autowired
    public EmployeeService employeeService;

    @GetMapping("/all")
    public String getAllMeetings(Model model) {
        model.addAttribute("meetings", meetingService.findAllMeetings());
        model.addAttribute("meeting", new MeetingModel());
        model.addAttribute("employees", employeeService.findAllEmployees());
        return "meetingList";
    }

    @PostMapping("/add")
    public String addMeeting(@Valid @ModelAttribute("meeting") MeetingModel meeting, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("meetings", meetingService.findAllMeetings());
            model.addAttribute("employees", employeeService.findAllEmployees());
            return "meetingList";
        }
        meetingService.addMeeting(meeting);
        return "redirect:/meetings/all";
    }

    @PostMapping("/update")
    public String updateMeeting(@Valid @ModelAttribute("meeting") MeetingModel meeting, BindingResult result) {
        meetingService.updateMeeting(meeting);
        return "redirect:/meetings/all";
    }

    @PostMapping("/delete")
    public String deleteMeeting(@RequestParam UUID id) {
        meetingService.deleteMeeting(id);
        return "redirect:/meetings/all";
    }

    @GetMapping("/all/{id}")
    public String getIdMeeting(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("meetings", meetingService.findMeetingById(id));
        model.addAttribute("meeting", new MeetingModel());
        model.addAttribute("employees", employeeService.findAllEmployees());
        return "meetingList";
    }

}
