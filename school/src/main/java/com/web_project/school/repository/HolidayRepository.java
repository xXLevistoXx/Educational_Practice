package com.web_project.school.repository;

import com.web_project.school.model.HolidayModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HolidayRepository extends JpaRepository<HolidayModel, UUID> {
}

