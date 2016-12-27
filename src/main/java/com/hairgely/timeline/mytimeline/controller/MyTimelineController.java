package com.hairgely.timeline.mytimeline.controller;

import com.hairgely.admin.hotel.controller.AbstractRestHandler;
import com.hairgely.timeline.mytimeline.service.MyTimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MyTimelineController extends AbstractRestHandler {

    @Autowired
    private MyTimelineService myTimelineService;

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public String view(Model model,
                       @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                       @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                       HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("itemList", myTimelineService.getAllPost(page, size));
        return  "base/list";
    }






}
