package br.com.altsystem.model;

import javax.persistence.Entity;

@Entity
public class Course extends AbstractEntity {

    private String nameCourse;

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }
}
