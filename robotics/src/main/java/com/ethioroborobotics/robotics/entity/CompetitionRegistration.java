package com.ethioroborobotics.robotics.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "competition_registration")
public class CompetitionRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer competitionId;

    @Column(name = "competition_name", nullable = false)
    private String competitionName;

    @Column(name = "location")
    private String location;

    @Column(name = "pricing_details")
    private String pricingDetails;

    @Column(name = "registration_link")
    private String registrationLink;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;

    @Column(name = "notes",columnDefinition = "TEXT")
    private String notes;
}
