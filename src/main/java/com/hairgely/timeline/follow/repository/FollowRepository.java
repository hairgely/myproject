package com.hairgely.timeline.follow.repository;


import com.hairgely.timeline.entity.Follow;
import com.hairgely.timeline.entity.Person;

import java.util.List;

public interface FollowRepository {

    public List<Person> findByIdNotEq(long id);

    public Follow save(Follow follow);

    void deleteFollow(Long id);
}