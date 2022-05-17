package dio.gym.entities;

import dio.gym.entities.transfers.AssessmentDTO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "tb_assessments")
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(nullable = false)
    private LocalDate evaluationDate;

    @Column(nullable = false)
    private Double weight;

    @Column(nullable = false)
    private Double height;

    public AssessmentDTO parse() {
        return AssessmentDTO.builder()
                .id(this.id)
                .student(this.student)
                .evaluationDate(parseEvaluationDate())
                .weight(this.weight)
                .height(this.height)
                .build();
    }

    public static AssessmentDTO parse(Assessment target) {
        return AssessmentDTO.builder()
                .id(target.id)
                .student(target.student)
                .evaluationDate(parseEvaluationDate(target.getEvaluationDate()))
                .weight(target.weight)
                .height(target.height)
                .build();
    }

    private String parseEvaluationDate() {
        return this.evaluationDate.toString();
    }

    private static String parseEvaluationDate(LocalDate target) {
        return target.toString();
    }

}
