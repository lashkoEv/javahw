package org.itstep.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {

    private Integer id;

    @NotBlank
    @NotNull
    private String firstName;

    @NotBlank
    @NotNull
    private String lastName;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startWork;

    private Set<Integer> groupId;

    private List<String> groupsName;

    public TeacherDto(Integer id, String firstName, String lastName, LocalDate startWork, List<String> groupsName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.startWork = startWork;
        this.groupsName = groupsName;
    }
}
