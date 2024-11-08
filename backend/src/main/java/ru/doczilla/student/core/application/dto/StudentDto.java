package ru.doczilla.student.core.application.dto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class StudentDto {
    private UUID id;

    private String firstName;

    private String lastName;

    private String patronymic;

    private Date birthday;

    private String group;
}
