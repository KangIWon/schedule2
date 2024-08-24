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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String description;
    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Comment(String username, String description, Schedule schedule) {
        this.username = username;
        this.description = description;
        this.createdDate = LocalDateTime.now();
        this.modifiedDate = LocalDateTime.now();
        this.schedule = schedule;
    }

    public void update(String username, String description) {
        this.username = username;
        this.description = description;
        this.modifiedDate = LocalDateTime.now();
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
