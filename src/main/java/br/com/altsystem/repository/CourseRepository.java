package br.com.altsystem.repository;

import br.com.altsystem.model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course,Long> {
    List<Course> findByNameCourseIgnoreCaseContaining(String nameCourse);
}
