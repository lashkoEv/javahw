package org.itstep.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Table(name = "groups")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Group {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Length(min = 1, max = 15)
    private String title;

}
