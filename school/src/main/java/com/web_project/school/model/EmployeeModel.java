package com.web_project.school.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "employees")
public class EmployeeModel {
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
    @Email(message = "Email не корректен")
    private String CorpEmail;
    @Column(columnDefinition = "boolean default false")
    private boolean deleted;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id")
    private PositionModel position;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private SubjectModel subject;

    @ManyToMany
    @JoinTable(name = "employee_meeting",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "meeting_id"))
    private List<MeetingModel> meetings;

    public EmployeeModel() {
    }

    public EmployeeModel(UUID id, String name, String firstName, @Nullable String lastName, @Nullable String corpEmail, boolean deleted, PositionModel position, SubjectModel subject, List<MeetingModel> meetings) {
        Id = id;
        Name = name;
        FirstName = firstName;
        LastName = lastName;
        CorpEmail = corpEmail;
        this.deleted = deleted;
        this.position = position;
        this.subject = subject;
        this.meetings = meetings;
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
    public @Email(message = "Email не корректен") String getCorpEmail() {
        return CorpEmail;
    }

    public void setCorpEmail(@Nullable @Email(message = "Email не корректен") String corpEmail) {
        CorpEmail = corpEmail;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public PositionModel getPosition() {
        return position;
    }

    public void setPosition(PositionModel position) {
        this.position = position;
    }

    public SubjectModel getSubject() {
        return subject;
    }

    public void setSubject(SubjectModel subject) {
        this.subject = subject;
    }

    public List<MeetingModel> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<MeetingModel> meetings) {
        this.meetings = meetings;
    }
}