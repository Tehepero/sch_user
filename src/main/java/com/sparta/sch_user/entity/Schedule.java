package com.sparta.sch_user.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Schedule extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Schedule(User user, String title, String description) {
        this.user = user;
        this.title = title;
        this.description = description;
    }

    public Schedule() {}

    public void update(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
