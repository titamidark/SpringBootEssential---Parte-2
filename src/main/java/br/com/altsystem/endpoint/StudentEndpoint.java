package br.com.altsystem.endpoint;

import br.com.altsystem.model.Student;
import br.com.altsystem.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("student")
public class StudentEndpoint {

    @Autowired
    private DateUtil dateUtil;

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<Student> listAll() {
        System.out.println("xxxxxxxxxxx" + dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()) + "xxxxxxxxxxx");
        return asList(new Student("Altamir Caetano"), new Student("Mustafá Ahimed"));
    }
}
