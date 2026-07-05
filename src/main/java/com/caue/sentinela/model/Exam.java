package com.caue.sentinela.model;

import com.caue.sentinela.model.enums.ExamResult;
import com.caue.sentinela.model.enums.ExamType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "exams")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ExamType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ExamResult result;

    @Column(nullable = false)
    private LocalDate examDate;

    private LocalDate expirationDate;

    @Column(nullable = false, length = 150)
    private String laboratory;

    @Column(length = 500)
    private String observations;

    public Exam() {
    }

    public Long getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public ExamType getType() {
        return type;
    }

    public void setType(ExamType type) {
        this.type = type;
    }

    public ExamResult getResult() {
        return result;
    }

    public void setResult(ExamResult result) {
        this.result = result;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(String laboratory) {
        this.laboratory = laboratory;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
}