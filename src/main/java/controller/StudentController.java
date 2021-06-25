package controller;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.IStudentService;

import java.util.Optional;

@RestController
@RequestMapping("/Student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @PostMapping("")
    public ResponseEntity<Student> create(@RequestBody Student student){
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Iterable<Student> showAll(){
        Iterable<Student> students = studentService.findAll();
        return students ;
    }

    @GetMapping("/Show")
    public ModelAndView show(){
        Iterable<Student> students = studentService.findAll();
        ModelAndView modelAndView = new ModelAndView("students");
        modelAndView.addObject("s",students);
        return modelAndView;
    }

//
//    @GetMapping(value = "{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
//    @ResponseBody
//    public Optional<Student> findById(@PathVariable Long id){
//        Optional<Student> students = studentService.findOne(id);
//        return students ;
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id){
        Optional<Student> student = studentService.findOne(id);
        return new ResponseEntity<Student>(student.get(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String remove(@PathVariable Long id){
        studentService.remove(id);
        return "ok";
    }

    @PutMapping(value = "/{Update}",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String updatte(@RequestBody Student student){
        studentService.save(student);
        return "ok";
    }

}
