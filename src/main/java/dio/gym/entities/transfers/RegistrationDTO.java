package dio.gym.entities.transfers;

import dio.gym.entities.Registration;
import dio.gym.entities.Student;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class RegistrationDTO {

    private Long id;
    private StudentDTO student;
    private String enrollmentDate;

    public Registration parse() {
        return Registration.builder()
                .id(this.id)
                .student(this.student.parse())
                .enrollmentDate(parseEnrollmentDate())
                .build();
    }

    public static Registration parse(RegistrationDTO target) {
        return Registration.builder()
                .id(target.id)
                .student(target.student.parse())
                .enrollmentDate(parseEnrollmentDate(target.getEnrollmentDate()))
                .build();
    }

    private LocalDate parseEnrollmentDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(this.enrollmentDate, formatter);
    }

    private static LocalDate parseEnrollmentDate(String target) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(target, formatter);
    }
}
