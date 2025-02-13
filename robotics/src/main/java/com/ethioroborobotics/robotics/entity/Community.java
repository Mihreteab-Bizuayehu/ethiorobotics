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
@Table(name = "community_services")
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer programId;

    @Column(name = "program_name", nullable = false)
    private String programName;

    @Column(name = "sponsored_students")
    private Integer sponsoredStudents;

    @Column(name = "institution", nullable = false)
    private String institution;

    @Column(name = "program_details")
    private String programDetails;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "current_status", nullable = false)
    private ProgramStatus currentStatus;

}
