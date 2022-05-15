package dio.gym.services.impls;

import dio.gym.entities.Registration;
import dio.gym.entities.transfers.RegistrationDTO;
import dio.gym.repositories.IRegistrationRepository;
import dio.gym.services.IRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RegistrationService implements IRegistrationService {

    @Autowired
    private IRegistrationRepository repository;

    @Override
    public RegistrationDTO findById(Long id) {
        Optional<Registration> found = repository.findById(id);
        return found
                .orElseThrow(() -> new RuntimeException("Not Found"))
                .parse();
    }

    @Override
    public Page<RegistrationDTO> findByEnrollmentDate(String enrollmentDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate enrollmentDateDate = LocalDate.parse(enrollmentDate, formatter);

        Page<RegistrationDTO> found = new PageImpl<>(
                repository.findByEnrollmentDate(enrollmentDateDate).stream()
                        .map(r -> r.parse())
                        .collect(Collectors.toList()));
        if (found.isEmpty()) {
            throw new RuntimeException("Not Found");
        }
        return found;
    }

    @Override
    public Page<RegistrationDTO> findByEnrollmentDateBetween(String start, String end) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(start, formatter);
        LocalDate endDate = LocalDate.parse(end, formatter);

        Page<RegistrationDTO> found = new PageImpl<>(
                repository.findByEnrollmentDateBetween(startDate, endDate)
                        .stream().map(r -> r.parse())
                        .collect(Collectors.toList()));

        if (found.isEmpty()) {
            throw new RuntimeException("Not Found");
        }
        return found;
    }

    @Override
    public Page<RegistrationDTO> findAll() {
        Page<RegistrationDTO> found = new PageImpl<>(
                repository.findAll().stream()
                        .map(r -> r.parse())
                        .collect(Collectors.toList()));

        if (found.isEmpty()) {
            throw new RuntimeException("Not Found");
        }
        return found;
    }

    @Override
    public String updateById(Long id, RegistrationDTO registration) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"))
                .setId(id);
        repository.save(registration.parse());
        return "Registration successfully updated";
    }

    @Override
    public String deleteById(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));
        repository.deleteById(id);
        return "Registration successfully removed";
    }
}
