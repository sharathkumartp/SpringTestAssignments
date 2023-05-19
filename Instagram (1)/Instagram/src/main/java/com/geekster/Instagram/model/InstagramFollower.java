package com.geekster.Instagram.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class InstagramFollower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long followerTableId;

    @OneToOne
    private User user;

    @OneToOne
    private User follower;

}
