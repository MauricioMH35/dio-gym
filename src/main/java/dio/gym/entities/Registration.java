package dio.gym.entities;

import dio.gym.entities.transfers.RegistrationDTO;
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
@Table(name = "tb_registrations")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(nullable = false)
    private LocalDate enrollmentDate;

    public RegistrationDTO parse() {
        return RegistrationDTO.builder()
                .id(this.id)
                .student(this.student.parse())
                .enrollmentDate(parseEnrollmentDate())
                .build();
    }

    public static RegistrationDTO parse(Registration target) {
        return RegistrationDTO.builder()
                .id(target.id)
                .student(target.student.parse())
                .enrollmentDate(parseEnrollmentDate(target.getEnrollmentDate()))
                .build();
    }

    private String parseEnrollmentDate() {
        return this.enrollmentDate.toString();
    }

    private static String parseEnrollmentDate(LocalDate target) {
        return target.toString();
    }

}
