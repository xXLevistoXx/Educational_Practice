package com.web_project.school.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Entity
@Table(name = "positions")
public class PositionModel {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private int salary;

    @OneToOne(optional = false, mappedBy = "position")
    private EmployeeModel owner;

    public PositionModel(){

    }

    public PositionModel(UUID id, String name, int salary, EmployeeModel owner) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.owner = owner;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public EmployeeModel getOwner() {
        return owner;
    }

    public void setOwner(EmployeeModel owner) {
        this.owner = owner;
    }
}
