package dio.gym.entities.transfers;

import dio.gym.entities.Assessment;
import dio.gym.entities.Student;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class AssessmentDTO {

    private Long id;
    private StudentDTO student;
    private String evaluationDate;
    private Double weight;
    private Double height;

    public Assessment parse() {
        return Assessment.builder()
                .id(this.id)
                .student(this.student.parse())
                .evaluationDate(parseEvaluationDate())
                .weight(this.weight)
                .height(this.height)
                .build();
    }

    public static Assessment parse(AssessmentDTO target) {
        return Assessment.builder()
                .id(target.id)
                .student(target.student.parse())
                .evaluationDate(parseEvaluationDate(target.getEvaluationDate()))
                .weight(target.weight)
                .height(target.height)
                .build();
    }

    private LocalDate parseEvaluationDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(this.evaluationDate, formatter);
    }

    private static LocalDate parseEvaluationDate(String target) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(target, formatter);
    }

}
