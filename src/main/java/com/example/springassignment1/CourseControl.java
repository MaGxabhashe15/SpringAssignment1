package com.example.SpringAssignment1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestControl
@RequestMapping("/courses")
public class CourseControl {

    @GetMapping("/list")
    public Map<String, List<String>> getCourses() {
        return Map.of(
                "Foundation Courses", List.of("Computer Literacy", "Introduction to programming concepts"),
                "Undergraduate Courses", List.of("Introduction to computers and computing", "Introduction to computing and programming concepts", "Elementary computer programming", "Advanced programming", "Computer architecture and organisation"),
                "Honours Courses", List.of("Computer Networks", "Distributed and parallel", "Advanced Java", "Computer graphics")
        );
    }
}


