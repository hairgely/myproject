package com.hairgely.timeline.newsfeed.controller;


import com.hairgely.timeline.entity.Post;
import com.hairgely.timeline.newsfeed.service.NewsfeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class NewsfeedController {

	@Autowired
	private NewsfeedService newsfeedService;

	@RequestMapping(value = "/newsfeed", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Post> findNewsfeedById(HttpServletRequest request, HttpServletResponse response) {
		return this.newsfeedService.findNewsfeedById(1L);
	}

}
