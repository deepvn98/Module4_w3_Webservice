package repo;

import model.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.lang.management.OperatingSystemMXBean;
import java.util.Optional;

@Repository
public interface IStudentRpo extends PagingAndSortingRepository<Student,Long> {
    Iterable<Student> findAllByNameContaining(String name);
}
