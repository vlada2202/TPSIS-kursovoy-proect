package com.carshowroom.repo;

import com.carshowroom.models.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comments, Long> {
}
