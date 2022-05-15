package dio.gym.services;

import dio.gym.entities.transfers.RegistrationDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface IRegistrationService {

    // Read
    RegistrationDTO findById(Long id);
    Page<RegistrationDTO> findByEnrollmentDate(String enrollmentDate);
    Page<RegistrationDTO> findByEnrollmentDateBetween(String start, String end);
    Page<RegistrationDTO> findAll();

    // Update
    String updateById(Long id, RegistrationDTO registration);

    // Delete
    String deleteById(Long id);

}
