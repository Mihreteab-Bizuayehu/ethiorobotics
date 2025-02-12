package com.ethioroborobotics.robotics.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "post_title")
    private String title;

    @Column(name="post_description", columnDefinition = "TEXT")
    private String content;

    @CreationTimestamp
    @Column(name = "date_created", updatable = false, nullable = false)
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    @Column(name = "date_modified")
    private LocalDateTime dateModified;

    @Column(name = "post_category")
    @Enumerated(EnumType.STRING)
    private PostCategory category;

    private boolean isActive;
}
