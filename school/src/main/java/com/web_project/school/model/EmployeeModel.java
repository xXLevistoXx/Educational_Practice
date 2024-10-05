package com.web_project.school.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Size(min = 3, message = "Имя не менее 3 символов")
    @Column(name = "Name") // Явно указываем имя столбца
    private String Name;

    @Size(min = 3, message = "Фамилия не менее 3 символов")
    private String FirstName;

    @Nullable
    private String LastName;

    @Nullable
    @Email(message = "Email не корректен")
    private String CorpEmail;

    @Nullable
    private String Position;

    @Column(columnDefinition = "boolean default false")
    private boolean deleted;

    // Геттеры и сеттеры
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    @Nullable
    public String getLastName() {
        return LastName;
    }

    public void setLastName(@Nullable String lastName) {
        LastName = lastName;
    }

    @Nullable
    public String getCorpEmail() {
        return CorpEmail;
    }

    public void setCorpEmail(@Nullable String corpEmail) {
        CorpEmail = corpEmail;
    }

    @Nullable
    public String getPosition() {
        return Position;
    }

    public void setPosition(@Nullable String position) {
        Position = position;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}