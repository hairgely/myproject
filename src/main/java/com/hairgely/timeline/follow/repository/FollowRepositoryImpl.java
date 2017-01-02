package com.hairgely.timeline.follow.repository;

import com.hairgely.timeline.entity.Follow;
import com.hairgely.timeline.entity.Person;
import com.hairgely.timeline.entity.QFollow;
import com.hairgely.timeline.entity.QPerson;
import com.hairgely.timeline.newsfeed.repository.NewsfeedRepository;
import com.querydsl.jpa.impl.JPADeleteClause;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FollowRepositoryImpl implements FollowRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Person> findByIdNotEq(final long id) {
        final JPAQuery<Person> query = new JPAQuery<>(em);
        final QPerson person = QPerson.person;
        final QFollow follow = QFollow.follow;

        return query.from(person).leftJoin(follow).on(person.userId.eq(follow.targetId)).where(person.userId.ne(id)).fetch();
    }

    @Override
    public Follow save(final Follow follow) {
        em.persist(follow);
        return follow;
    }

    @Override
    public void deleteFollow(Long id) {
        QFollow qFollow = QFollow.follow;
        new JPADeleteClause(em, qFollow).where(qFollow.targetId.eq(id)).execute();
    }

//    @Override
//    public Person save(final Person person) {
//        em.persist(person);
//        return person;
//    }

//    @Override
//    public List<Person> findPersonsByFirstnameAndSurnameQueryDSL(final String firstname, final String surname) {
//        final JPAQuery<Person> query = new JPAQuery<>(em);
//        final QPerson person = QPerson.person;
//
//        return query.from(person).where(person.firstname.eq(firstname).and(person.surname.eq(surname))).fetch();
//    }
//
//    @Override
//    public List<Person> findPersonsByFirstnameInDescendingOrderQueryDSL(final String firstname) {
//        final JPAQuery<Person> query = new JPAQuery<>(em);
//        final QPerson person = QPerson.person;
//
//        return query.from(person).where(person.firstname.eq(firstname)).orderBy(person.surname.desc()).fetch();
//    }
//
//    @Override
//    public int findMaxAge() {
//        final JPAQuery<Person> query = new JPAQuery<>(em);
//        final QPerson person = QPerson.person;
//
//        return query.from(person).select(person.age.max()).fetchFirst();
//    }
//
//    @Override
//    public Map<String, Integer> findMaxAgeByName() {
//        final JPAQuery<Person> query = new JPAQuery<>(em);
//        final QPerson person = QPerson.person;
//
//        return query.from(person).transform(GroupBy.groupBy(person.firstname).as(GroupBy.max(person.age)));
//    }

}