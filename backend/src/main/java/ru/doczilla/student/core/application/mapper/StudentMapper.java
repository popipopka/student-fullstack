package ru.doczilla.student.core.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.doczilla.student.core.application.dto.StudentCreateRequestDto;
import ru.doczilla.student.core.application.dto.StudentDto;
import ru.doczilla.student.core.domain.Student;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {
    Student toDomain(StudentCreateRequestDto createRequestDto);

    StudentDto toDto(Student student);
}
