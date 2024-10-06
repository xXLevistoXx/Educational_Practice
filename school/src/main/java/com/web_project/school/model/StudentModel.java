package com.web_project.school.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Id;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "students")
public class StudentModel {
    @Id
    @GeneratedValue
    private UUID Id;
    @Size(min = 3, message = "Имя не менее 3 символов")
    private String Name;
    @Size(min = 3, message = "Фамилия не менее 3 символов")
    private String FirstName;
    @Nullable
    private String LastName;
    @Nullable
    @Email(message = "Емеил не корректен")
    private String CorpEmail;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    private PassportModel passport;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private UniversityModel university;

    @ManyToMany
    @JoinTable(name = "student_holiday",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "holiday_id"))
    private List<HolidayModel> holidays;

    public StudentModel() {
    }

    public StudentModel(UUID id, String name, String firstName, @Nullable String lastName, @Nullable String corpEmail, PassportModel passport, UniversityModel university, List<HolidayModel> holidays) {
        Id = id;
        Name = name;
        FirstName = firstName;
        LastName = lastName;
        CorpEmail = corpEmail;
        this.passport = passport;
        this.university = university;
        this.holidays = holidays;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public @Size(min = 3, message = "Имя не менее 3 символов") String getName() {
        return Name;
    }

    public void setName(@Size(min = 3, message = "Имя не менее 3 символов") String name) {
        Name = name;
    }

    public @Size(min = 3, message = "Фамилия не менее 3 символов") String getFirstName() {
        return FirstName;
    }

    public void setFirstName(@Size(min = 3, message = "Фамилия не менее 3 символов") String firstName) {
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
    public @Email(message = "Емеил не корректен") String getCorpEmail() {
        return CorpEmail;
    }

    public void setCorpEmail(@Nullable @Email(message = "Емеил не корректен") String corpEmail) {
        CorpEmail = corpEmail;
    }

    public PassportModel getPassport() {
        return passport;
    }

    public void setPassport(PassportModel passport) {
        this.passport = passport;
    }

    public UniversityModel getUniversity() {
        return university;
    }

    public void setUniversity(UniversityModel university) {
        this.university = university;
    }

    public List<HolidayModel> getHolidays() {
        return holidays;
    }

    public void setHolidays(List<HolidayModel> holidays) {
        this.holidays = holidays;
    }
}


