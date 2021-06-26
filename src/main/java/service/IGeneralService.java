package service;

import model.Student;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findOne(Long id);

    void save(T t);

    void remove(Long id);

    Iterable<Student> findStudentByName(String name);


}
