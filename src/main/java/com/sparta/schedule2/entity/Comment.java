package com.sparta.schedule2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "comments")
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String username;

    public Comment(String description, String username) {
        this.description = description;
        this.createdDate = LocalDateTime.now();
        this.modifiedDate = LocalDateTime.now();
        this.username = username;
    }

    public void update(String description, String username) {
        this.description = description;
        this.modifiedDate = LocalDateTime.now();
        this.username = username;
    }
}
