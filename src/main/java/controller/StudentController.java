package controller;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.IStudentService;

import java.util.Optional;

@RestController
@RequestMapping("Student/")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @PostMapping(value = "Create",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String create(@RequestBody Student student) {
        studentService.save(student);
        return "Thành công!";
    }

    @GetMapping(value = "Show",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Iterable<Student> showAll(){
        Iterable<Student> students = studentService.findAll();
        return students ;
    }
//
//    @GetMapping(value = "{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
//    @ResponseBody
//    public Optional<Student> findById(@PathVariable Long id){
//        Optional<Student> students = studentService.findOne(id);
//        return students ;
//    }

    @GetMapping("{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id){
        Optional<Student> student = studentService.findOne(id);
        return new ResponseEntity<Student>(student.get(), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String remove(@PathVariable Long id){
        studentService.remove(id);
        return "ok";
    }

    @PutMapping(value = "{Update}",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String updatte(@RequestBody Student student){
        studentService.save(student);
        return "ok";
    }

}
