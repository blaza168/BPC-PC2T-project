package com.blaaazha.domain.models;

import com.blaaazha.domain.models.base.Person;
import com.google.common.collect.ImmutableList;
import lombok.Builder;
import lombok.Getter;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Date;

@Getter
public class Teacher extends Person {

    protected final ImmutableList<Student> students;

    public Teacher(int id, String firstname, String surname, Date birth) {
        this(id, firstname, surname,birth,null);
    }

    @Builder
    public Teacher(int id, String firstname, String surname, Date birth,  @Nullable Collection<Student> students) {
        super(id, firstname, surname, birth);
        this.students = students == null ? ImmutableList.of() : ImmutableList.copyOf(students);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", birth=" + birth +
                '}';
    }
}
