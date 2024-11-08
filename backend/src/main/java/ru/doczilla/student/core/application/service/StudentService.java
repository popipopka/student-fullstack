package ru.doczilla.student.core.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.doczilla.student.core.application.dto.StudentCreateRequestDto;
import ru.doczilla.student.core.application.dto.StudentDto;
import ru.doczilla.student.core.application.mapper.StudentMapper;
import ru.doczilla.student.core.application.repository.StudentRepository;
import ru.doczilla.student.core.domain.Student;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentDto createStudent(StudentCreateRequestDto createDto) {
        Student newStudent = studentMapper.toDomain(createDto);

        studentRepository.save(newStudent);

        return studentMapper.toDto(newStudent);
    }

    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toDto)
                .toList();
    }

    public void deleteStudentById(UUID id) {
        studentRepository.deleteById(id);
    }
}
