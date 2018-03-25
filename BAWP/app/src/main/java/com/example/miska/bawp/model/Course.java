package com.example.miska.bawp.model;

import android.content.Context;

public class Course {
    private String courseName;
    private String image;
    private String authorImage;

    public Course(String courseName, String image, String authorImage) {
        this.courseName = courseName;
        this.image = image;
        this.authorImage = authorImage;
    }

    public int getImageResourceID(Context context){
        return context.getResources().getIdentifier(this.image, "drawable", context.getPackageName());
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthorImage() {
        return authorImage;
    }

    public void setAuthorImage(String authorImage) {
        this.authorImage = authorImage;
    }
}
