package com.hairgely.timeline.mytimeline.repository;

import com.hairgely.timeline.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyTimelineRepository extends PagingAndSortingRepository<Post, Long> {
    Page findAll(Pageable pageable);
}
