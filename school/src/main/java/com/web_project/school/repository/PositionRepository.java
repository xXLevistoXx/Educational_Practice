package com.web_project.school.repository;

import com.web_project.school.model.PositionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PositionRepository extends JpaRepository<PositionModel, UUID> {

}