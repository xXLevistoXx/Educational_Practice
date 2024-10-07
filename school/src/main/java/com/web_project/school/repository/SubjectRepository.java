package com.web_project.school.repository;

import com.web_project.school.model.StudentModel;
import com.web_project.school.model.SubjectModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubjectRepository extends JpaRepository<SubjectModel, UUID> {

}
