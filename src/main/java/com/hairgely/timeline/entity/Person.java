package com.hairgely.timeline.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    private String name;

    @OneToMany
    @JoinColumn(name = "TARGET_ID", insertable = false, updatable = false)
    private List<Follow> follw;

//    @OneToMany
//    @JoinColumn(name = "USER_ID", insertable = false, updatable = false)
//    private List<Post> post;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Follow> getFollw() {
        return follw;
    }

    public void setFollw(List<Follow> follw) {
        this.follw = follw;
    }
//
//    public List<Post> getPost() {
//        return post;
//    }
//
//    public void setPost(List<Post> post) {
//        this.post = post;
//    }
}