package com.example.miska.bawp.data;


import com.example.miska.bawp.model.Course;

import java.util.ArrayList;

public class CourseData {

    private String[] courseNames = {"First Course", "Second Course", "Third Course",
            "Fourth Course", "Fifth Course", "Sixth Course", "Seventh Course"};

    public ArrayList<Course> courseList(){
        ArrayList<Course> list = new ArrayList<>();
        for (int i = 0; i < courseNames.length; i++){
            Course course = new Course(courseNames[i], courseNames[i].replace(" ", "").toLowerCase(), "husky");
            list.add(course);
        }
        return list;
    }

}
