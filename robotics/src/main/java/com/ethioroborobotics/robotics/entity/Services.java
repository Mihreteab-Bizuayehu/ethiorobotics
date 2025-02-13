package com.ethioroborobotics.robotics.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "services")
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceId;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private ServiceCategory category;

    @Column(columnDefinition = "TEXT",name = "description", nullable = false)
    private String description;

    @Column(name = "location")
    private String location;

    @Column(name = "target_audience")
    private String targetAudience;

    @Column(name = "contact_info")
    private String contactInfo;
}
