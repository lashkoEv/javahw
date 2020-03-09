package org.itstep.data;

import org.itstep.model.Group;
import org.itstep.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@Repository
public class StudentRepository implements org.itstep.data.Repository<Student, Integer> {

    public static final String QUERY_STUDENT_BY_ID = "SELECT id, first_name, last_name, age, \"group\" from students where id=?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentRepository(JdbcTemplate jdbcTemplate
    ) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = SQLException.class, noRollbackFor = FileNotFoundException.class)
    @Override
    public Integer save(Student data) {
        int groupId = isValidGroup(data);
        if (groupId == -1) {
            return -1;
        }
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps =
                    con.prepareStatement("insert into students(first_name, last_name, age, \"group\") values(?, ?, ?, ?)",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, data.getFirstName());
            ps.setString(2, data.getLastName());
            ps.setInt(3, data.getAge());
            ps.setInt(4, groupId);
            return ps;
        }, holder);
        return Objects.requireNonNull(holder.getKey()).intValue();
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = SQLException.class, noRollbackFor = FileNotFoundException.class)
    @Override
    public int update(Student data) {
        int groupId = isValidGroup(data);
        if (groupId == -1) {
            return -1;
        }
        jdbcTemplate.update(con -> {
            PreparedStatement ps =
                    con.prepareStatement("update students set first_name=?, last_name=?, age=?, \"group\"=? where id=?",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, data.getFirstName());
            ps.setString(2, data.getLastName());
            ps.setInt(3, data.getAge());
            ps.setString(4, data.getGroup());
            ps.setInt(5, data.getId());
            return ps;
        });
        return 0;
    }

    private int isValidGroup(Student data) {
        List<Group> query = jdbcTemplate.query("select id, group_name from groups",
                (rs, rowNum) -> new Group(rs.getInt("id"),
                        rs.getString("group_name")));
        int groupId = -1;
        for (int i = 0;i < query.size();i++){
            if(query.get(i).getGroupName().equals(data.getGroup())){
                groupId = query.get(i).getId();
            }
        }
        return groupId;
    }

    @Transactional
    @Override
    public boolean delete(Student data) {
        return jdbcTemplate.update("delete from students where id=?", data.getId()) != 0;
    }

    @Override
    public List<Student> findAll() {
        return jdbcTemplate.query("select students.id, first_name, last_name, age, group_name from students, groups where \"group\" = groups.id",
                (rs, rowNum) -> new Student(rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("age"),
                        rs.getString("group_name")));
    }

    @Transactional(readOnly = true)
    @Override
    public Student find(Integer id) {
        Student student = null;
            student = jdbcTemplate.queryForObject(QUERY_STUDENT_BY_ID,
                    new Object[]{id},
                    new BeanPropertyRowMapper<>(Student.class)
            );
        return student;
    }
}
