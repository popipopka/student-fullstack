package ru.doczilla.student.web.controller;

import ru.doczilla.student.core.application.dto.StudentCreateRequestDto;
import ru.doczilla.student.core.application.dto.StudentDto;
import ru.doczilla.student.core.application.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Void> createStudent(@RequestBody StudentCreateRequestDto createDto,
                                              UriComponentsBuilder uriBuilder) {
        StudentDto student = studentService.createStudent(createDto);

        return ResponseEntity
                .created(uriBuilder
                        .pathSegment("{id}")
                        .build(Map.of("id", student.getId())))
                .build();
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> students = studentService.getAllStudents();

        return students.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(students);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable UUID id) {
        studentService.deleteStudentById(id);

        return ResponseEntity.ok().build();
    }
}
