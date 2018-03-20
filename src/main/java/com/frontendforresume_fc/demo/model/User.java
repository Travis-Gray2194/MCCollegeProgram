package com.frontendforresume_fc.demo.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.awt.datatransfer.FlavorEvent;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String password;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    public User(String password, String username, String firstName, String lastName, String email) {
        this.password = password;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Requirement> studentRequirements;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Programme> appliedProgramme;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Programme> approvedProgramme;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Programme> acceptedProgramme;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Requirement> getStudentRequirements() {
        return studentRequirements;
    }

    public void setStudentRequirements(Set<Requirement> studentRequirements) {
        this.studentRequirements = studentRequirements;
    }

    public Set<Programme> getAppliedProgramme() {
        return appliedProgramme;
    }

    public void setAppliedProgramme(Set<Programme> appliedProgramme) {
        this.appliedProgramme = appliedProgramme;
    }

    public Set<Programme> getAcceptedProgramme() {
        return acceptedProgramme;
    }

    public Set<Programme> getApprovedProgramme() {
        return approvedProgramme;
    }

    public void setApprovedProgramme(Set<Programme> approvedProgramme) {
        this.approvedProgramme = approvedProgramme;
    }

    public void setAcceptedProgramme(Set<Programme> acceptedProgramme) {
        this.acceptedProgramme = acceptedProgramme;
    }

    public void addProgramme(Programme programme){
        this.appliedProgramme.add(programme);
}

    public boolean containsProgram(Programme programme) {
        return this.appliedProgramme.contains(programme) || this.acceptedProgramme.contains(programme);
    }

    public void addRequirement(Requirement requirement){
        this.studentRequirements.add(requirement);
    }
}