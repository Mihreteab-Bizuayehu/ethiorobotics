package com.ethioroborobotics.robotics.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String courseName;

    @Enumerated(EnumType.STRING)
    private CourseCategory category;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String targetAudience;

    private String duration;

    @Column(columnDefinition = "TEXT",length = 500)
    private String prerequisites;

    @Column(columnDefinition = "TEXT",length = 500)
    private String resources;

}
