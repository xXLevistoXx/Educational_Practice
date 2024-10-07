package com.web_project.school.service;

import com.web_project.school.model.SubjectModel;

import java.util.List;
import java.util.UUID;

public interface SubjectService {
    public List<SubjectModel> findAllSubjects();

    public SubjectModel findSubjectById(UUID id);

    public SubjectModel addSubject(SubjectModel subject);

    public SubjectModel updateSubject(SubjectModel subject);

    public void deleteSubject(UUID id);
}
