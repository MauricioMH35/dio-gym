package dio.gym.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dio.gym.entities.transfers.StudentDTO;
import dio.gym.utils.StringToLocalDate;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "tb_students")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 64)
    private String name;

    @Column(unique = true, nullable = false, length = 14)
    private String cpf;

    @Column(length = 64)
    private String neighborhood;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private LocalDate registration;

    @JsonIgnore
    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private List<Assessment> assessments;

    public StudentDTO parse() {
        return StudentDTO.builder()
                .id(this.id)
                .name(this.name)
                .cpf(this.cpf)
                .neighborhood(this.neighborhood)
                .birthDate(StringToLocalDate.parse(this.birthDate))
                .registration(this.registration)
                .assessments(null)
                .build();
    }

    public static StudentDTO parse(Student target) {
        return StudentDTO.builder()
                .id(target.id)
                .name(target.name)
                .cpf(target.cpf)
                .neighborhood(target.neighborhood)
                .birthDate(StringToLocalDate.parse(target.birthDate))
                .registration(target.registration)
                .assessments(null)
                .build();
    }

}
