package service.impl;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.IStudentRpo;
import service.IStudentService;

import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRpo studentRpo;

    @Override
    public Iterable<Student> findAll() {
        return studentRpo.findAll();
    }

    @Override
    public Optional<Student> findOne(Long id) {
        return studentRpo.findById(id);
    }

    @Override
    public void save(Student student) {
        studentRpo.save(student);
    }

    @Override
    public void remove(Long id) {
        studentRpo.deleteById(id);
    }
}
