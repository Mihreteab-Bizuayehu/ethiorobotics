package com.ethioroborobotics.robotics.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "partners")
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer partnerId;

    @Column(name = "partner_name", nullable = false)
    private String partnerName;

    @Column(name = "contact_person")
    private String contactPerson;

    @Column(name = "contact_email")
    private String contactEmail;

    @Column(name = "contact_phone")
    private String contactPhone;

    @Column(name = "partnership_start_date", nullable = false)
    private LocalDate partnershipStartDate;

    @Column(name = "partnership_end_date")
    private LocalDate partnershipEndDate;

    @Column(columnDefinition = "TEXT",name = "description", nullable = false)
    private String description;
}
