package com.blaaazha.domain.models.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public abstract class Person {
    protected final int id;
    protected final String firstname;
    protected final String surname;
    protected final Date birth;
}
