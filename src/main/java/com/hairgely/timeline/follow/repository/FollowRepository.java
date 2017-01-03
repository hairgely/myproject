package com.hairgely.timeline.follow.repository;


import com.hairgely.timeline.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FollowRepository extends CrudRepository<Follow, Long>, JpaRepository<Follow, Long>, FollowDslRepository {
    public List<Follow> findById(long id);
}