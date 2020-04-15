package br.com.altsystem.endpoint;

import br.com.altsystem.error.CustomErrorType;
import br.com.altsystem.error.ResourceNotFoundException;
import br.com.altsystem.model.Course;
import br.com.altsystem.repository.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping(path = "/findByName/{nameCourse}")
    public ResponseEntity<?> findByCourseByName(@PathVariable String nameCourse){
        return new ResponseEntity<>(courseDAO.findByNameCourseIgnoreCaseContaining(nameCourse),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Course course){
        return new ResponseEntity<>(courseDAO.save(course), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable("id") Long id){
        verifyIfCourseExists(id);
        Optional<Course> course = courseDAO.findById(id);
        return new ResponseEntity<>(course,HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        verifyIfCourseExists(id);
        courseDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Course course) {
        verifyIfCourseExists(course.getId());
        courseDAO.save(course);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    private void verifyIfCourseExists(Long id){
        Optional<Course> course = courseDAO.findById(id);
        if (!course.isPresent())
            throw new ResourceNotFoundException("Course not found for ID " +id);
    }



}

