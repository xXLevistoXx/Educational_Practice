package com.web_project.school.service;

import com.web_project.school.model.StudentModel;

import java.util.List;

public interface StudentService {
    public List<StudentModel> findAllStudents();

    public StudentModel findStudentById(Long id);

    public StudentModel addStudent(StudentModel student);

    public StudentModel updateStudent(StudentModel student);

    public void deleteStudent(Long id);
}


