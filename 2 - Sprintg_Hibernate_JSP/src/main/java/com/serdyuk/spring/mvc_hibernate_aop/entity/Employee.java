package com.serdyuk.spring.mvc_hibernate_aop.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Size(min = 2, message = "name must be min 2 symbols")
    @Column(name = "name")
    private String name;

    @Size(min = 2, message = "lastname must be min 2 symbols")
    @Column(name = "lastname")
    private String lastname;

    @NotBlank(message = "surname is required field")
    @Column(name = "surname")
    private String surname;

    @Column(name = "department")
    private String department;

    @Min(value = 100, message = "must be greater than 99")
    @Max(value = 50000, message = "must be less than 50001")
    @Column(name = "salary")
    private int salary;

    @Column(name = "phone_number")
    @Pattern(regexp = "\\d{3}-\\d{2}-\\d{2}", message = "please use pattern XXX-XX-XX")
    private String phoneNumber;


    public Employee() {

    }

    public Employee(String name, String lastname, String surname, String department, int salary, String phoneNumber) {
        this.name = name;
        this.lastname = lastname;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
