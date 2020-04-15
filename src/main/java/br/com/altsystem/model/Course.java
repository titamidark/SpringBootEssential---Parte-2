package br.com.altsystem.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
public class Course extends AbstractEntity {

    @NotEmpty
    private String nameCourse;

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }
}
