package ru.doczilla.student.core.application.dto;

import lombok.Data;

import java.util.Date;

@Data
public class StudentCreateRequestDto {
    private String firstName;

    private String lastName;

    private String patronymic;

    private Date birthday;

    private String group;
}
