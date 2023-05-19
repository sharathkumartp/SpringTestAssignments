package com.geekster.Instagram.repository;

import com.geekster.Instagram.model.InstagramFollower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFollowerRepo extends JpaRepository<InstagramFollower, Long> {
}
