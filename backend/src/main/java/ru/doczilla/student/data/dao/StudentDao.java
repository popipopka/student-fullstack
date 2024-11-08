package ru.doczilla.student.data.dao;

import ru.doczilla.student.core.domain.Student;
import ru.doczilla.student.core.application.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class StudentDao implements StudentRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final RowMapper<Student> rowMapper;

    @Override
    public void save(Student student) {
        final String query = """
                insert into student (id, first_name, last_name, patronymic, birthday, "group")
                values (:id, :firstName, :lastName, :patronymic, :birthday, :group)
                """;

        Map<String, Object> params = Map.of(
                "id", student.getId(),
                "firstName", student.getFirstName(),
                "lastName", student.getLastName(),
                "patronymic", student.getPatronymic(),
                "birthday", student.getBirthday(),
                "group", student.getGroup()
        );

        jdbcTemplate.update(query, params);
    }

    @Override
    public List<Student> findAll() {
        final String query = "select * from student";

        return jdbcTemplate.query(query, rowMapper);
    }

    @Override
    public void deleteById(UUID id) {
        final String query = "delete from student where id = :id";
        Map<String, Object> params = Map.of("id", id);

        jdbcTemplate.update(query, params);
    }
}
