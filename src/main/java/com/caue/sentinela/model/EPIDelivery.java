package com.caue.sentinela.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "epi_deliveries")
public class EPIDelivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "epi_id", nullable = false)
    private EPI epi;

    @Column(nullable = false)
    private LocalDate deliveryDate;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivered_by_user_id", nullable = false)
    private User deliveredBy;

    @Column(nullable = false)
    private Boolean employeeSigned;

    @Column(length = 500)
    private String observations;

    public EPIDelivery() {
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

    public EPI getEpi() {
        return epi;
    }

    public void setEpi(EPI epi) {
        this.epi = epi;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDeliveredBy() {
        return deliveredBy;
    }

    public void setDeliveredBy(String deliveredBy) {
        this.deliveredBy = deliveredBy;
    }

    public Boolean getEmployeeSigned() {
        return employeeSigned;
    }

    public void setEmployeeSigned(Boolean employeeSigned) {
        this.employeeSigned = employeeSigned;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
}