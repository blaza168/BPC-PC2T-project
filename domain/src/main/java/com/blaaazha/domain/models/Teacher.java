package com.blaaazha.domain.models;

import com.blaaazha.domain.models.base.Person;
import com.google.common.collect.ImmutableList;
import lombok.Getter;

import javax.annotation.Nullable;
import java.util.Date;

@Getter
public class Teacher extends Person {
    private final ImmutableList<Student> students;


    public Teacher(int id, String firstname, String surname, Date birth) {
        this(id, firstname, surname,birth,null);
    }

    public Teacher(int id, String firstname, String surname, Date birth,  @Nullable ImmutableList<Student> students) {
        super(id, firstname, surname, birth);
        this.students = students == null ? ImmutableList.of() : ImmutableList.copyOf(students);
    }
}
