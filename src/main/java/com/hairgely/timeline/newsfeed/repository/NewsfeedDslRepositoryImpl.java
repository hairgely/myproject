package com.hairgely.timeline.newsfeed.repository;

import com.hairgely.timeline.entity.*;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.annotations.Parent;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class NewsfeedDslRepositoryImpl extends QueryDslRepositorySupport implements NewsfeedDslRepository {

    @PersistenceContext
    private EntityManager em;

    public NewsfeedDslRepositoryImpl() {
        super(Parent.class);
    }

    @Override
    public List<Post> findNewsfeedById(final long id) {
        final JPAQuery<Post> query = new JPAQuery<>(em);
        final QPost post = QPost.post;
        final QFollow follow = QFollow.follow;
        final QPerson person = QPerson.person;

        return query.from(post)
                        .join(post.person, person)
                        .join(person.follw, follow)
                        .where(follow.id.eq(id)).fetch();
    }


}