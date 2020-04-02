package org.itstep.model;

import lombok.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Student {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @NotBlank
    private String firstName;

    @NotBlank
    @NonNull
    private String lastName;

    @Range(min = 8, max = 60)
    @NonNull
    private int age;

    @NotBlank
    @NonNull
    @Column(name = "group_id")
    private String group;

    @Past
    @NonNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;

    private double score;

    private Role role = Role.STUDENT;
}
