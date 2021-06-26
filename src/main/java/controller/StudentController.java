package controller;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.IStudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student){
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> showAll(){
        List<Student> students = (List<Student>) studentService.findAll();
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @GetMapping("Show")
    public ModelAndView show(){
        Iterable<Student> students = studentService.findAll();
        ModelAndView modelAndView = new ModelAndView("students");
        modelAndView.addObject("s",students);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return new ResponseEntity<>(studentService.findOne(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable Long id){
        studentService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{Update}")
    public ResponseEntity<?>update(@RequestBody Student student){
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<?> search(@PathVariable String name){
        return new ResponseEntity<>(studentService.findStudentByName(name),HttpStatus.OK);
    }

}
