package org.itstep.domain;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Table(name = "teacher")
@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Teacher implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @NotBlank
    @Length(max = 50)
    @Column(name = "first_name")
    private String firstName;

    @NonNull
    @NotBlank
    @Length(max = 50)
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @NonNull
    @Length(max = 50)
    @Column(name = "login", nullable = false)
    private String login;

    @NotBlank
    @NonNull
    @Length(max = 50)
    private String password;

    @NotBlank
    @NonNull
    @Length(max = 50)
    private String role;

    @ManyToMany(mappedBy = "teachers", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    List<Group> groups = new ArrayList<>();

    public Teacher groups(List<Group> groups) {
        this.groups = groups;
        return this;
    }

    public Teacher addGroups(Group groups) {
        this.groups.add(groups);
        groups.getTeachers().add(this);
        return this;
    }

    public Teacher removeGroups(Group groups) {
        this.groups.remove(groups);
        groups.getTeachers().remove(this);
        return this;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList(role);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}