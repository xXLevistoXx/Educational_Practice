package com.web_project.school.repository;

import com.web_project.school.model.PassportModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PassportRepository extends JpaRepository<PassportModel, UUID> {
}

