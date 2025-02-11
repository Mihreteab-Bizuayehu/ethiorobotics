package com.ethioroborobotics.robotics.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer applicantId;

    @Column(name = "full_name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_interest", nullable = false)
    private RoleInterest roleInterest;

    @Column(name = "availability")
    private String availability;

    @Column(name = "skills")
    private String skills;

    @Column(name = "message")
    private String message;

    @Column(name = "application_date", nullable = false)
    private LocalDate applicationDate;

}
