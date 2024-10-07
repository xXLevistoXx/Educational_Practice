package com.web_project.school.repository;

import com.web_project.school.model.MeetingModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MeetingRepository extends JpaRepository<MeetingModel, UUID> {

}
