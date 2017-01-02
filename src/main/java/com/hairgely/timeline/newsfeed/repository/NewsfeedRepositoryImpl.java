package com.hairgely.timeline.newsfeed.repository;

import com.hairgely.timeline.entity.*;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class NewsfeedRepositoryImpl implements NewsfeedRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Post> findPostById(final long id) {
        final JPAQuery<Post> query = new JPAQuery<>(em);
        final QPost post = QPost.post;
        final QFollow follow = QFollow.follow;

        return query.from(post).join(follow).on(post.userId.eq(follow.targetId)).where(follow.id.eq(id)).orderBy(post.createDate.desc()).fetch();
    }


}