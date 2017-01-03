package com.hairgely.timeline.follow.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class FollowDslRepositoryImpl implements FollowDslRepository {

    @PersistenceContext
    private EntityManager em;





}