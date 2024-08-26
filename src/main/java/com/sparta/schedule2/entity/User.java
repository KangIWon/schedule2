package com.sparta.schedule2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<UserSchedule> userSchedules = new HashSet<>();

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.createdDate = LocalDateTime.now();
        this.modifiedDate = LocalDateTime.now();
    }

    public void update(String username, String email) {
        this.username = username;
        this.email = email;
        this.modifiedDate = LocalDateTime.now();
    }
}
