package repo;

import model.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRpo extends PagingAndSortingRepository<Student,Long> {
}
