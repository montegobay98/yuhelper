package com.yuhelper.core.controller;


import com.yuhelper.core.model.Course;
import com.yuhelper.core.service.CourseService;
import com.yuhelper.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CourseController {
    @Autowired
    CourseService service;

    @Autowired
    UserService userService;

    @GetMapping(value = "/course")
    public ModelAndView getCourse(@RequestParam String q) {
        Course course = service.searchByName(q);
        ModelAndView model = new ModelAndView("course.html");
        model.addObject("course", course);
        model.addObject("courseOfferings", course.getCourseOfferings());
        userService.addUserToModel(model);
        return model;
    }

}
