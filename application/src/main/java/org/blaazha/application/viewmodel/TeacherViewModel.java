package org.blaazha.application.viewmodel;

import com.blaaazha.domain.models.Student;
import com.blaaazha.domain.models.Teacher;
import com.google.common.collect.ImmutableList;
import lombok.Getter;
import javax.annotation.Nullable;
import java.util.Date;

@Getter
public class TeacherViewModel extends Teacher {

    protected final int money;

    public TeacherViewModel(int id, String firstname, String surname, Date birth, int money) {
        super(id, firstname, surname, birth);
        this.money = money;
    }

    public TeacherViewModel(int id, String firstname, String surname, Date birth, @Nullable ImmutableList<Student> students, int money) {
        super(id, firstname, surname, birth, students);
        this.money = money;
    }

    @Override
    public String toString() {
        return "TeacherViewModel{" +
                "money=" + money +
                ", id=" + id +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", birth=" + birth +
                '}';
    }
}
