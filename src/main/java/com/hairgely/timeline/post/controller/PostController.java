package com.hairgely.timeline.post.controller;

import com.hairgely.timeline.entity.Post;
import com.hairgely.timeline.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/post", method = RequestMethod.POST,  consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String createPost(@RequestBody Post post, HttpServletRequest request, HttpServletResponse response) {
        try {
            post.prePersist();
            postService.save(post);
            return "ok";
        }catch (Exception e){
            return e.getMessage();
        }

    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.DELETE, produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deletePost(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) {
        this.postService.deletePost(id);

    }
}
