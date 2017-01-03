package com.hairgely.timeline.follow.controller;

import com.hairgely.timeline.entity.Follow;
import com.hairgely.timeline.entity.Person;
import com.hairgely.timeline.follow.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FollowController {

    @Autowired
    private FollowService followService;

    @RequestMapping(value = "/follow", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Map<String, Object> getFriendsFollow(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("itemList", followService.findByIdNotEq(1L));
       return  result;
    }


    @RequestMapping(value = "/follow", method = RequestMethod.POST,  consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String createFollow(@RequestBody Follow follow, HttpServletRequest request, HttpServletResponse response) {
        try {
            follow.prePersist();
            followService.save(follow);
            return "ok";
        }catch (Exception e){
            return e.getMessage();
        }

    }

    @RequestMapping(value = "/follow/{id}", method = RequestMethod.DELETE, produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFollow(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) {
        this.followService.deleteFollow(id);
    }
}
