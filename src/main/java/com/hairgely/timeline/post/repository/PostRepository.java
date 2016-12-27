package com.hairgely.timeline.post.repository;

import com.hairgely.timeline.domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository can be used to delegate CRUD operations against the data source: http://goo.gl/P1J8QH
 */
@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
}
