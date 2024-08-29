package com.sparta.schedule2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<UserSchedule> userSchedules = new HashSet<>();

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public void update(String username, String email) {
        this.username = username;
        this.email = email;
    }

//    public void addAssignedSchedule(UserSchedule userSchedule) {
//        this.userSchedules.add(userSchedule);
//    }

    public void removeAssignedSchedule(Schedule schedule) {
        userSchedules.removeIf(userSchedule -> userSchedule.getSchedule().equals(schedule));
    }
}
