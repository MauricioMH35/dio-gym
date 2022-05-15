package dio.gym.entities.transfers;

import dio.gym.entities.Assessment;
import dio.gym.entities.Student;
import lombok.*;
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
    private List<Assessment> assessments;

    public Student parse() {
        return Student.builder()
                .id(this.id)
                .name(this.name)
                .cpf(this.cpf)
                .neighborhood(this.neighborhood)
                .birthDate(parseBirthDate())
                .assessments(null)
                .build();
    }

    public static Student parse(StudentDTO target) {
        return Student.builder()
                .id(target.id)
                .name(target.name)
                .cpf(target.cpf)
                .neighborhood(target.neighborhood)
                .birthDate(parseBirthDate(target.getBirthDate()))
                .assessments(null)
                .build();
    }

    private LocalDate parseBirthDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(this.birthDate, formatter);
    }

    private static LocalDate parseBirthDate(String target) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(target, formatter);
    }

}
