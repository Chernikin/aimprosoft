package com.chernikin.aimprosoft.domain;

import java.util.Date;

public class Employee {

    private long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String email;
    private String phoneNumber;
    private Date employmentDate;
    private Date dismissalDate;
    private Department department;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String patronymic, String email, String phoneNumber, Date employmentDate, Date dismissalDate, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.employmentDate = employmentDate;
        this.dismissalDate = dismissalDate;
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public Date getDismissalDate() {
        return dismissalDate;
    }

    public void setDismissalDate(Date dismissalDate) {
        this.dismissalDate = dismissalDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", employmentDate=" + employmentDate +
                ", dismissalDate=" + dismissalDate +
                ", department=" + department +
                '}';
    }
}
