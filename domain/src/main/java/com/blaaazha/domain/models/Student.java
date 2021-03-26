package com.blaaazha.domain.models;

import com.blaaazha.domain.models.base.Person;
import com.google.common.collect.ImmutableList;
import lombok.Getter;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Date;

@Getter
public class Student extends Person {
    private final float average;
    private final ImmutableList<Teacher> teachers;

    public Student(int id, String firstname, String surname, Date birth, float average) {
        this(id, firstname, surname, birth, average, null);
    }

    public Student(int id, String firstname, String surname, Date birth,  float average, @Nullable Collection<Teacher> teachers) {
        super(id, firstname, surname, birth);
        this.average = average;
        this.teachers = teachers == null ? ImmutableList.of() : ImmutableList.copyOf(teachers);
    }
}
