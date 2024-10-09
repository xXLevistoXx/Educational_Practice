package com.web_project.school.controllers;

import com.web_project.school.model.SubjectModel;
import com.web_project.school.service.SubjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/subjects")
@PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
public class SubjectController {
    @Autowired
    public SubjectService subjectService;


    @GetMapping("/all")
    public String getAllSubjects(Model model) {
        model.addAttribute("subjects", subjectService.findAllSubjects());
        model.addAttribute("subject", new SubjectModel());
        return "subjectList";
    }

    @PostMapping("/add")
    public String addSubject(@Valid @ModelAttribute("subject") SubjectModel subject, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("subjects", subjectService.findAllSubjects());
            return "subjectList";
        }
        subjectService.addSubject(subject);
        return "redirect:/subjects/all";
    }

    @PostMapping("/update")
    public String updateSubject(@Valid @ModelAttribute("subject") SubjectModel subject, BindingResult result) {
        subjectService.updateSubject(subject);
        return "redirect:/subjects/all";
    }

    @PostMapping("/delete")
    public String deleteSubject(@RequestParam UUID id) {
        subjectService.deleteSubject(id);
        return "redirect:/subjects/all";
    }

    @GetMapping("/all/{id}")
    public String getIdSubject(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("subjects", subjectService.findSubjectById(id));
        model.addAttribute("subject", new SubjectModel());
        return "subjectList";
    }

}
