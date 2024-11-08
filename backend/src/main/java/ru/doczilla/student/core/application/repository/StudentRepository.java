package ru.doczilla.student.core.application.repository;

import ru.doczilla.student.core.domain.Student;

import java.util.List;
import java.util.UUID;

public interface StudentRepository {
    void save(Student student);

    List<Student> findAll();

    void deleteById(UUID id);
}
