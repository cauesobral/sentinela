package com.caue.sentinela.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "epis",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_epi_ca",
                        columnNames = "certificate_approval"
                )
        }
)
public class EPI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 20)
    private String certificateApproval;

    @Column(nullable = false, length = 100)
    private String manufacturer;

    @Column(nullable =false)
    private LocalDate expirationDate;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private Boolean active = true;

    @OneToMany(mappedBy = "epi")
    private List<EPIDelivery> deliveries = new ArrayList<>();

    public EPI() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCa() {
        return ca;
    }

    public void setCa(String ca) {
        this.ca = ca;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<EPIDelivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<EPIDelivery> deliveries) {
        this.deliveries = deliveries;
    }

}
