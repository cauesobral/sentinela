package com.caue.sentinela.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "physicians",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_physician_crm", columnNames = "crm")
        }
)
public class Physician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String fullName;

    @Column(nullable = false, unique = true, length = 20)
    private String crm;

    @Column(nullable = false, length = 2)
    private String crmState;

    @Column(length = 150)
    private String specialty;

    @Column(length = 150)
    private String email;

    @Column(length = 20)
    private String phone;

    @Column(nullable = false)
    private Boolean active = true;

    @OneToMany(mappedBy = "physician")
    private List<ASO> asos = new ArrayList<>();

    public Physician() {
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

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getCrmState() {
        return crmState;
    }

    public void setCrmState(String crmState) {
        this.crmState = crmState;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<ASO> getAsos() {
        return asos;
    }

    public void setAsos(List<ASO> asos) {
        this.asos = asos;
    }

}