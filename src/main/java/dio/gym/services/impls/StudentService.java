package dio.gym.services.impls;

import dio.gym.entities.Student;
import dio.gym.entities.transfers.StudentDTO;
import dio.gym.handlers.ConflictException;
import dio.gym.handlers.NotFoundException;
import dio.gym.repositories.IStudentRepository;
import dio.gym.services.IStudentService;
import dio.gym.utils.PlaintextToCpf;
import dio.gym.utils.StringToLocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@Component
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository repository;

    @Override
    public StudentDTO create(StudentDTO student) {
        if (student == null)
            throw new RuntimeException("Error");
        if (repository.findByCpf(student.getCpf()).isPresent())
            throw new ConflictException("Student already exists");

        student.setRegistration(LocalDate.now());
        repository.save(student.parse());
        return student;
    }

    @Override
    public StudentDTO findById(Long id) {
        return findStudentById(id);
    }

    @Override
    public StudentDTO findByCpf(String cpf) {
        return findStudentByCpf(cpf);
    }

    @Override
    public Page<StudentDTO> findByNameContains(String name) {
        Page<StudentDTO> found = new PageImpl<>(
                repository.findByNameContains(name).stream()
                        .map(s -> s.parse())
                        .collect(Collectors.toList()));
        if (found.isEmpty()) {
            throw new RuntimeException("Not Found");
        }
        return found;
    }

    @Override
    public Page<StudentDTO> findByNeighborhood(String neighborhood) {
        Page<StudentDTO> found = new PageImpl<>(
                repository.findByNeighborhood(neighborhood).stream()
                        .map(s -> s.parse())
                        .collect(Collectors.toList()));
        if (found.isEmpty()) {
            throw new RuntimeException("Not Found");
        }
         return found;
    }

    @Override
    public Page<StudentDTO> findByBirthDateBetween(String start, String end) {
        LocalDate startDate = StringToLocalDate.parse(start);
        LocalDate endDate = StringToLocalDate.parse(end);

        Page<StudentDTO> found = new PageImpl<>(
                repository.findByBirthDateBetween(startDate, endDate).stream()
                        .map(s -> s.parse())
                        .collect(Collectors.toList()));
        if (found.isEmpty()) {
            throw new RuntimeException("Not Found");
        }
        return found;
    }

    @Override
    public Page<StudentDTO> findByRegistrationBetween(String start, String end) {
        LocalDate startDate = StringToLocalDate.parse(start);
        LocalDate endDate = StringToLocalDate.parse(end);

        Page<StudentDTO> found = new PageImpl<>(
                repository.findByRegistrationBetween(startDate, endDate).stream()
                        .map(s -> s.parse())
                        .collect(Collectors.toList())
        );

        if (found.isEmpty()) {
            throw new NotFoundException("Students find between registration "+start+" and "+end+" Not found");
        }

        return found;
    }

    @Override
    public Page<StudentDTO> findAll() {
        Page<StudentDTO> found = new PageImpl<>(
                repository.findAll().stream()
                        .map(s -> s.parse())
                        .collect(Collectors.toList()));
        if (found.isEmpty()) {
            throw new RuntimeException("Not Found");
        }
        return found;
    }

    @Override
    public String updateById(Long id, StudentDTO student) {
        StudentDTO found = findStudentById(id);
        student.setId(id);
        student.setCpf(found.getCpf());
        repository.save(student.parse());
        return "Student successfully saved";
    }

    @Override
    public String updateByCpf(String cpf, StudentDTO student) {
        StudentDTO found = findStudentByCpf(cpf);
        student.setId(found.getId());
        student.setCpf(found.getCpf());
        repository.save(student.parse());
        return "Student successfully saved";
    }

    @Override
    public String deleteById(Long id) {
        Student found = findStudentById(id).parse();
        repository.deleteById(id);
        return "Student successfully deleted";
    }

    @Override
    public String deleteByCpf(String cpf) {
        StudentDTO found = findStudentByCpf(cpf);
        repository.deleteById(found.getId());
        return "Student successfully deleted";
    }

    private StudentDTO findStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"))
                .parse();
    }

    private StudentDTO findStudentByCpf(String cpf) {
        cpf = PlaintextToCpf.parse(cpf);

        return repository.findByCpf(cpf)
                .orElseThrow(()-> new RuntimeException("Not Found"))
                .parse();
    }

}
