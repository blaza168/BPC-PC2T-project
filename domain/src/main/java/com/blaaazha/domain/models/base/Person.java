package com.blaaazha.domain.models.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public abstract class Person {
    private final int id;
    private final String firstname;
    private final String surname;
    private final Date birth;
}
