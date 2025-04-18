package com.example.springassignment1;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Courses {

    private long id;
    @NotBlank(message = "Course code must not be blank")
    private String Course_Code;
    @NotBlank(message = "Course name must not be blank")
    @Size(min = 3, message = "Course name must be at least 3 characters long")
    private String Course_Name;

    public Courses() {}
    
    public Courses(long id, String Course_Code, String Course_Name){
        this.id =  id;
        this.Course_Code = Course_Code;
        this.Course_Name = Course_Name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setCourse_Code(String course_Code) {
        Course_Code = course_Code;
    }

    public String getCourse_Code() {
        return Course_Code;
    }

    public void setCourse_Name(String course_Name) {
        Course_Name = course_Name;
    }

    public String getCourse_Name() {
        return Course_Name;
    }
}
