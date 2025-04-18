package com.example.springassignment1;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping
    public List<Courses> getAllCourses() {
        return courseService.getAllCourses();
    }
    public ResponseEntity<Courses> getCourseById(@PathVariable long id) {
        Courses course = courseService.getCourseById(id);
        return (course != null) ? ResponseEntity.ok(course) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Courses> createCourse(@Valid @RequestBody Courses course) {
        return ResponseEntity.ok(courseService.addCourse(course));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Courses> updateCourse
            (@PathVariable long id, @Valid @RequestBody Courses course) {
        Optional<Courses> updated = courseService.updateCourse(id, course);
        if (updated != null) return (ResponseEntity<Courses>) ResponseEntity.ok();
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable long id) {
        return (courseService.deleteCourse(id)) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }




    @GetMapping("/all")
    public Map<String, List<Courses>> getCourses(){
        return Map.of(
                "Foundation Courses", List.of(
                        new Courses(1, "CSC111F", "Computer Literacy"),
                        new Courses(2, "CSC121F", "Introduction to Programming Concepts")
                ),"Undergraduate Courses", List.of(
                        new Courses(3, "CSC113", "Intro to Computing And Programming Concepts"),
                        new Courses(4, "CSC121", "Introduction to Visual Basics"),
                        new Courses(5, "CSC211", "Advanced Programming"),
                        new Courses(6, "CSC212", "Computer Architecture And Organisation"),
                        new Courses(7, "CSC223", "Data Structures and Algorithms")
                ),
                "Honours Courses", List.of(
                        new Courses(8, "CSC501", "Mini Project"),
                        new Courses(9, "CSC512", "Computer Networks"),
                        new Courses(10, "CSC513", "Distributed and Parallel Computing"),
                        new Courses(11, "CSH304", "Advanced Java")
                )

        );
    }
}
