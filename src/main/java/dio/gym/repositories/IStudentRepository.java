package dio.gym.repositories;

import dio.gym.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByCpf(String cpf);
    List<Student> findByNameContains(String name);
    List<Student> findByNeighborhood(String neighborhood);
    List<Student> findByBirthDateBetween(LocalDate start, LocalDate end);
}
