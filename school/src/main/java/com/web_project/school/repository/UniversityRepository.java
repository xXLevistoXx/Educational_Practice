package com.web_project.school.repository;

import com.web_project.school.model.UniversityModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UniversityRepository extends JpaRepository<UniversityModel, UUID> {
}

