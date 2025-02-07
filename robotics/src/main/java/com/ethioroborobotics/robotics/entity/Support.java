package com.ethioroborobotics.robotics.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "support")
public class Support {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supportId;

    @Enumerated(EnumType.STRING)
    @Column(name = "support_type", nullable = false)
    private SupportType supportType;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "contact_method", nullable = false)
    private String contactMethod;

    @Column(name = "contact_details", nullable = false)
    private String contactDetails;

    @Column(name = "availability", nullable = false)
    private String availability;
}
