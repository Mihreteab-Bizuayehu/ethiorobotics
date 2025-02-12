package com.ethioroborobotics.robotics.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Getter
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

    @Column(name = "contact_person",nullable = false)
    private String contactPerson;

    @Column(name = "contact_email",unique = true,updatable = true)
    private String contactEmail;

    @Column(name = "contact_phone")
    private String contactPhone;

    @CreationTimestamp
    @Column(name = "partnership_start_date",updatable = false)
    private LocalDate partnershipStartDate;

    @CreationTimestamp
    @Column(name = "partnership_end_date",updatable = false)
    private LocalDate partnershipEndDate;

    @Column(columnDefinition = "TEXT",name = "description", nullable = false)
    private String description;
}
