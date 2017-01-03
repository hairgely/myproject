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
    public List<Person> findNewsfeedById(final long id) {
        final JPAQuery<Person> query = new JPAQuery<>(em);
        final QPost post = QPost.post;
        final QFollow follow = QFollow.follow;
        final QPerson person = QPerson.person;

        return query.from(person)
                        .leftJoin(person.follw, follow)
                        .leftJoin(person.post, post)
                        .where(person.userId.eq(id)).fetch();
    }


}