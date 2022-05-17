package dio.gym.services;

import dio.gym.entities.transfers.StudentDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface IStudentService {

    // Create
    StudentDTO create(StudentDTO student);

    // Read
    StudentDTO findById(Long id);
    StudentDTO findByCpf(String cpf);
    Page<StudentDTO> findByNameContains(String name);
    Page<StudentDTO> findByNeighborhood(String neighborhood);
    Page<StudentDTO> findByBirthDateBetween(String start, String end);
    Page<StudentDTO> findByRegistrationBetween(String start, String end);
    Page<StudentDTO> findAll();

    // Update
    String updateById(Long id, StudentDTO student);
    String updateByCpf(String cpf, StudentDTO student);

    // Delete
    String deleteById(Long id);
    String deleteByCpf(String cpf);

}
