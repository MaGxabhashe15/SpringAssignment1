package com.example.springassignment1;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service

public class CourseService {
    private final Map<Long, Courses> courseMap = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    public List<Courses> getAllCourses() {
        return new ArrayList<>(courseMap.values());
    }

    public Courses getCourseById(long id) {
        return courseMap.get(id);
    }

    public Courses addCourse(Courses course) {
        long id = idCounter.incrementAndGet();
        course.setId(id);
        courseMap.put(id, course);
        return course;
    }

    public Optional<Courses> updateCourse(long id, Courses updatedCourse) {
        if (courseMap.containsKey(id)) {
            updatedCourse.setId(id);
            courseMap.put(id, updatedCourse);
            return Optional.of(updatedCourse);
        }
        return Optional.empty();
    }

    public boolean deleteCourse(long id) {
        return courseMap.remove(id) != null;
    }

}
