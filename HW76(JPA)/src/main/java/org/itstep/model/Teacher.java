package org.itstep.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Set;

@Table(name = "teachers")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private LocalDate startWork;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Group> groups;

    public Teacher(String firstName, String lastName, LocalDate startWork, Set<Group> groupSet) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startWork = startWork;
        this.groups = groupSet;
    }
}
