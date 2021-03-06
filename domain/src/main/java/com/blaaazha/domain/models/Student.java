package com.blaaazha.domain.models;

import com.blaaazha.domain.models.base.Person;
import com.google.common.collect.ImmutableList;
import lombok.Builder;
import lombok.Getter;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Date;

@Getter
public class Student extends Person {
    protected final ImmutableList<Teacher> teachers;
    protected final ImmutableList<Integer> marks;

    public Student(int id, String firstname, String surname, Date birth) {
        this(id, firstname, surname, birth, null, null);
    }

    @Builder
    public Student(int id, String firstname, String surname, Date birth, @Nullable Collection<Teacher> teachers, @Nullable Collection<Integer> marks) {
        super(id, firstname, surname, birth);
        this.teachers = teachers == null ? ImmutableList.of() : ImmutableList.copyOf(teachers);
        this.marks = marks == null ? ImmutableList.of() : ImmutableList.copyOf(marks);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", birth=" + birth +
                '}';
    }
}
