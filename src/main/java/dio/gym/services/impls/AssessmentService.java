package dio.gym.services.impls;

import dio.gym.entities.transfers.AssessmentDTO;
import dio.gym.repositories.IAssessmentRepository;
import dio.gym.services.IAssessmentService;
import dio.gym.utils.StringToLocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.stream.Collectors;

@Component
public class AssessmentService implements IAssessmentService {

    @Autowired
    private IAssessmentRepository repository;

    @Override
    public AssessmentDTO create(AssessmentDTO assessment) {
        if (assessment == null) {
            throw new RuntimeException("Error");
        }
        repository.save(assessment.parse());
        return assessment;
    }

    @Override
    public AssessmentDTO findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"))
                .parse();
    }

    @Override
    public Page<AssessmentDTO> findByEvaluationDate(String evaluationData) {
        LocalDate date = StringToLocalDate.parse(evaluationData);
        Page<AssessmentDTO> found = new PageImpl<>(repository.findByEvaluationDate(date).stream()
                .map(a -> a.parse())
                .collect(Collectors.toList()));
        if (found.isEmpty()) {
            throw new RuntimeException("Not Found");
        }
        return found;
    }

    @Override
    public Page<AssessmentDTO> findByEvaluationDateBetweem(String start, String end) {
        LocalDate startDate = StringToLocalDate.parse(start);
        LocalDate endDate = StringToLocalDate.parse(end);

        Page<AssessmentDTO> found = new PageImpl<>(
                repository.findByEvaluationDateBetween(startDate, endDate).stream()
                        .map(a -> a.parse())
                        .collect(Collectors.toList()));
        if (found.isEmpty()) {
            throw new RuntimeException("Not Found");
        }
        return found;
    }

    @Override
    public Page<AssessmentDTO> findByWeight(Double weight) {
        Page<AssessmentDTO> found = new PageImpl<>(
                repository.findByWeight(weight).stream()
                        .map(a -> a.parse())
                        .collect(Collectors.toList()));

        if (found.isEmpty()) {
            throw new RuntimeException("Not Found");
        }
        return found;
    }

    @Override
    public Page<AssessmentDTO> findByWeightBetween(Double start, Double end) {
        Page<AssessmentDTO> found = new PageImpl<>(
                repository.findByWeightBetween(start, end).stream()
                        .map(a -> a.parse())
                        .collect(Collectors.toList()));

        if (found.isEmpty()) {
            throw new RuntimeException("Not Found");
        }
        return found;
    }

    @Override
    public Page<AssessmentDTO> findByHeight(Double height) {
        Page<AssessmentDTO> found = new PageImpl<>(
                repository.findByHeight(height).stream()
                        .map(a -> a.parse())
                        .collect(Collectors.toList()));

        if (found.isEmpty()) {
            throw new RuntimeException("Not Found");
        }
        return found;
    }

    @Override
    public Page<AssessmentDTO> findByHeightBetween(Double start, Double end) {
        Page<AssessmentDTO> found = new PageImpl<>(
                repository.findByHeightBetween(start, end).stream()
                        .map(a -> a.parse())
                        .collect(Collectors.toList()));

        if (found.isEmpty()) {
            throw new RuntimeException("Not Found");
        }
        return found;
    }

    @Override
    public Page<AssessmentDTO> findAll() {
        Page<AssessmentDTO> found = new PageImpl<>(
                repository.findAll().stream()
                        .map(a -> a.parse())
                        .collect(Collectors.toList()));

        if (found.isEmpty()) {
            throw new RuntimeException("Not Found");
        }
        return found;
    }

    @Override
    public String updateById(Long id, AssessmentDTO assessment) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));
        assessment.setId(id);
        repository.save(assessment.parse());
        return "Assessment successfully updated";
    }

    @Override
    public String deleteById(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nor Found"));
        repository.deleteById(id);
        return "Assessment successfully removed";
    }
}
