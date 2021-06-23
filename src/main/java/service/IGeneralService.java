package service;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findOne(Long id);

    void save(T t);

    void remove(Long id);

}
