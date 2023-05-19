package com.geekster.Instagram.repository;

import com.geekster.Instagram.model.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILikeRepo extends JpaRepository<PostLike, Long> {
    long countByPost_PostId(Long postId);

}
