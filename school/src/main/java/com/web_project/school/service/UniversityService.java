package com.web_project.school.service;

import com.web_project.school.model.UniversityModel;

import java.util.List;
import java.util.UUID;

public interface UniversityService {
    public List<UniversityModel> findAllUniversities();

    public UniversityModel findUniversityById(UUID id);

    public UniversityModel addUniversity(UniversityModel university);

    public UniversityModel updateUniversity(UniversityModel university);

    public void deleteUniversity(UUID id);
}

