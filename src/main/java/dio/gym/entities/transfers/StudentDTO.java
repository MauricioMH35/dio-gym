package dio.gym.entities.transfers;

import dio.gym.entities.Assessment;
import dio.gym.entities.Student;
import dio.gym.utils.StringToLocalDate;
import lombok.*;
import org.apache.tomcat.jni.Local;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class StudentDTO {

    private Long id;
    private String name;
    private String cpf;
    private String neighborhood;
    private String birthDate;
    private LocalDate registration;
    private List<Assessment> assessments;

    public Student parse() {
        return Student.builder()
                .id(this.id)
                .name(this.name)
                .cpf(this.cpf)
                .neighborhood(this.neighborhood)
                .birthDate(StringToLocalDate.parse(this.birthDate))
                .registration(this.registration)
                .assessments(this.assessments)
                .build();
    }

    public static Student parse(StudentDTO target) {
        return Student.builder()
                .id(target.id)
                .name(target.name)
                .cpf(target.cpf)
                .neighborhood(target.neighborhood)
                .birthDate(StringToLocalDate.parse(target.getBirthDate()))
                .registration(target.getRegistration())
                .assessments(target.getAssessments())
                .build();
    }

}
