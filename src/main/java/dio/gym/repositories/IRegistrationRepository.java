package dio.gym.repositories;

import dio.gym.entities.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IRegistrationRepository extends JpaRepository<Registration, Long> {

    List<Registration> findByEnrollmentDate(LocalDate enrollmentDate);
    List<Registration> findByEnrollmentDateBetween(LocalDate start, LocalDate end);

}
