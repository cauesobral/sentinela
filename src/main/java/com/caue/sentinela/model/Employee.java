package com.caue.sentinela.model;

import com.caue.sentinela.model.enums.BiologicalSex;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "employees",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_employee_cpf", columnNames = "cpf"),
                @UniqueConstraint(name = "uk_employee_registration", columnNames = "registration")
        }
)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String fullName;

    @Column(nullable = false, unique = true, length = 14)
    private String cpf;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BiologicalSex biologicalSex;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private LocalDate admissionDate;

    private LocalDate dismissalDate;

    @Column(nullable = false, unique = true, length = 20)
    private String registration;

    @Column(nullable = false)
    private Boolean active = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @OneToMany(mappedBy = "employee")
    private List<Accident> accidents = new ArrayList<>();

    @OneToMany(mappedBy = "employee")
    private List<ASO> asos = new ArrayList<>();

    @OneToMany(mappedBy = "employee")
    private List<Exam> exams = new ArrayList<>();

    @OneToMany(mappedBy = "employee")
    private List<Training> trainings = new ArrayList<>();

    @OneToMany(mappedBy = "employee")
    private List<EPIDelivery> epiDeliveries = new ArrayList<>();

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public BiologicalSex getBiologicalSex() {
        return biologicalSex;
    }

    public void setBiologicalSex(BiologicalSex biologicalSex) {
        this.biologicalSex = biologicalSex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public LocalDate getDismissalDate() {
        return dismissalDate;
    }

    public void setDismissalDate(LocalDate dismissalDate) {
        this.dismissalDate = dismissalDate;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public List<Accident> getAccidents() {
        return accidents;
    }

    public void setAccidents(List<Accident> accidents) {
        this.accidents = accidents;
    }

    public List<ASO> getAsos() {
        return asos;
    }

    public void setAsos(List<ASO> asos) {
        this.asos = asos;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public List<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }

    public List<EPIDelivery> getEpiDeliveries() {
        return epiDeliveries;
    }

    public void setEpiDeliveries(List<EPIDelivery> epiDeliveries) {
        this.epiDeliveries = epiDeliveries;
    }
}