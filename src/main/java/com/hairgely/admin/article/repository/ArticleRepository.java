package com.hairgely.admin.article.repository;

import com.hairgely.admin.article.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {}
