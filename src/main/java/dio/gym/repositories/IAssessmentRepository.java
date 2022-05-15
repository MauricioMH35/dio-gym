package dio.gym.repositories;

import dio.gym.entities.Assessment;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IAssessmentRepository extends JpaRepository<Assessment, Long> {
    List<Assessment> findByEvaluationDate(LocalDate evaluationData);
    List<Assessment> findByEvaluationDateBetween(LocalDate start, LocalDate end);
    List<Assessment> findByWeight(Double weight);
    List<Assessment> findByWeightBetween(Double start, Double end);
    List<Assessment> findByHeight(Double height);
    List<Assessment> findByHeightBetween(Double start, Double end);
}
