package dio.gym.services;

import dio.gym.entities.Assessment;
import dio.gym.entities.transfers.AssessmentDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface IAssessmentService {

    // Create
    AssessmentDTO create(AssessmentDTO assessment);

    // Read
    AssessmentDTO findById(Long id);
    Page<AssessmentDTO> findByEvaluationDate(String evaluationData);
    Page<AssessmentDTO> findByEvaluationDateBetweem(String start, String end);
    Page<AssessmentDTO> findByWeight(Double weight);
    Page<AssessmentDTO> findByWeightBetween(Double start, Double end);
    Page<AssessmentDTO> findByHeight(Double height);
    Page<AssessmentDTO> findByHeightBetween(Double start, Double end);
    Page<AssessmentDTO> findAll();

    // Update
    String updateById(Long id, AssessmentDTO assessment);

    // Delete
    String deleteById(Long id);

}
