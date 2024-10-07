package com.web_project.school.repository;

import com.web_project.school.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, UUID> {
    @Query("SELECT e FROM EmployeeModel e WHERE " +
            "e.deleted = false AND " +
            "e.Name LIKE %:value% " +
            "OR e.FirstName LIKE %:value% " +
            "OR e.LastName LIKE %:value% OR " +
            "e.CorpEmail LIKE %:value")
    List<EmployeeModel> searchByAnyField(@Param("value") String value);

    @Query("SELECT e FROM EmployeeModel e WHERE e.deleted = false")
    List<EmployeeModel> findAllActive();
}