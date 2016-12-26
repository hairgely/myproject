package com.hairgely.admin.article.repository;

import com.hairgely.admin.article.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {}
