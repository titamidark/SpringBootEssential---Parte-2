package br.com.altsystem.endpoint;

import br.com.altsystem.error.CustomErrorType;
import br.com.altsystem.model.Course;
import br.com.altsystem.repository.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("courses")
public class CourseEndpoint {

    private final CourseRepository courseDAO;

    public CourseEndpoint(CourseRepository courseDAO) {
        this.courseDAO = courseDAO;
    }

    @GetMapping
    public ResponseEntity<?> listAll(){
        return new ResponseEntity<>(courseDAO.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Course course){
        return new ResponseEntity<>(courseDAO.save(course), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable("id") Long id){
        Optional<Course> course = courseDAO.findById(id);

        if (course == null)
            return new ResponseEntity<>(new CustomErrorType("Course Not Found"),HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(course,HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        courseDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Course course) {
        courseDAO.save(course);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

}

