package com.sparta.schedule2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Table(name = "schedules")
@NoArgsConstructor
public class Schedule extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<UserSchedule> assignees = new HashSet<>();

    private String title;
    private String description;
    
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    public Schedule(User user, String title, String description) {
        this.user = user;
        this.title = title;
        this.description = description;
        this.createdDate = LocalDateTime.now();
        this.modifiedDate = LocalDateTime.now();
    }

    public void update(String title, String description) {
        this.title = title;
        this.description = description;
        this.modifiedDate = LocalDateTime.now();
    }

//    public void addAssignedUser(User user) {
//        UserSchedule assignee = new UserSchedule(user, this);
//        this.assignees.add(assignee);
//        if (!user.getUserSchedules().contains(assignee)) {
//            user.addAssignedSchedule(assignee);
//        }
//    }

    public List<User> getAssignedUsers() {
        return assignees.stream().map(UserSchedule::getUser).toList();
    }

    public void removeAssignedUser(User user) {
        assignees.removeIf(assignee -> assignee.getUser().equals(user) && assignee.getSchedule().equals(this));
    }
}
