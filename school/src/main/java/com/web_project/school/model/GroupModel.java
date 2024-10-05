package com.web_project.school.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
public class GroupModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Size(min = 3, message = "Название не менее 3 символов")
    @Column(name = "Name")
    private String Name;
    @ManyToOne
    @JoinColumn(name = "StudentId")
    @Nullable
    private StudentModel student;

    @ManyToOne
    @JoinColumn(name = "EmployeeId")
    @Nullable
    private EmployeeModel employee;

    public GroupModel(int id, String name, @Nullable StudentModel student, @Nullable EmployeeModel employee) {
        Id = id;
        Name = name;
        this.student = student;
        this.employee = employee;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public @Size(min = 3, message = "Название не менее 3 символов") String getName() {
        return Name;
    }

    public void setName(@Size(min = 3, message = "Название не менее 3 символов") String name) {
        Name = name;
    }

    @Nullable
    public StudentModel getStudent() {
        return student;
    }

    public void setStudent(@Nullable StudentModel student) {
        this.student = student;
    }

    @Nullable
    public EmployeeModel getEmployee() {
        return employee;
    }

    public void setEmployee(@Nullable EmployeeModel employee) {
        this.employee = employee;
    }
}

