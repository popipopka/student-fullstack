package ru.doczilla.student.core.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Builder
@Data
public class Student {
    @Builder.Default
    private UUID id = UUID.randomUUID();

    private String firstName;

    private String lastName;

    private String patronymic;

    private Date birthday;

    private String group;
}
