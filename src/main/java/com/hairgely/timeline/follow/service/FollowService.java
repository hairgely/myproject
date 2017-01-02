package com.hairgely.timeline.follow.service;

import com.hairgely.timeline.entity.Follow;
import com.hairgely.timeline.entity.Person;
import com.hairgely.timeline.follow.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {

    @Autowired
    private FollowRepository followRepository;

    public Follow save(Follow follow) {
        return followRepository.save(follow);
    }

    public List<Person> findByIdNotEq(long i) {
        return followRepository.findByIdNotEq(i);
    }

    public void deleteFollow(Long id) {
        followRepository.deleteFollow(id);
    }
}
