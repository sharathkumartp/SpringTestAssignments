package com.geekster.Instagram.repository;

import com.geekster.Instagram.model.InstagramComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepo extends JpaRepository<InstagramComment, Long> {
}
