package com.sparta.schedule2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "schedules")
@NoArgsConstructor
public class Schedule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String title;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Schedule(String username, String title, String description) {
        this.username = username;
        this.title = title;
        this.description = description;
        this.createdDate = LocalDateTime.now();
        this.modifiedDate = LocalDateTime.now();
    }

    public void update(String username, String title, String description) {
        this.username = username;
        this.title = title;
        this.description = description;
        this.modifiedDate = LocalDateTime.now();
    }
}
