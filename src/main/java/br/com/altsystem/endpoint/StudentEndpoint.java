package br.com.altsystem.endpoint;

import br.com.altsystem.error.CustomErrorType;
import br.com.altsystem.model.Student;
import br.com.altsystem.utils.DateUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("students")
public class StudentEndpoint {

    private final DateUtil dateUtil;

    public StudentEndpoint(DateUtil dateUtil) {
        this.dateUtil = dateUtil;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll() {
        System.out.println("xxxxsxxxxxxx" + dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()) + "xxxxxxxxxxx");
        return new ResponseEntity<>(Student.studentList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") int id) {
        Student student = new Student();
        student.setId(id);
        int index = Student.studentList.indexOf(student);

        if (index == -1)
            return new ResponseEntity<>(new CustomErrorType("Student NOT FOUND!"), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(Student.studentList.get(index), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Student student) {
        Student.studentList.add(student);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }
}
