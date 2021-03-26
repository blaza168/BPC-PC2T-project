package org.blaazha.application.viewmodel;

import com.blaaazha.domain.models.Student;
import com.blaaazha.domain.models.Teacher;
import lombok.Getter;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Date;

@Getter
public class StudentViewModel extends Student {

    protected final int money;

    public StudentViewModel(int id, String firstname, String surname, Date birth, int money) {
        super(id, firstname, surname, birth);
        this.money = money;
    }

    public StudentViewModel(int id, String firstname, String surname, Date birth, @Nullable Collection<Teacher> teachers, @Nullable Collection<Integer> marks, int money) {
        super(id, firstname, surname, birth, teachers, marks);
        this.money = money;
    }

    @Override
    public String toString() {
        return "StudentViewModel{" +
                "money=" + money +
                ", id=" + id +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", birth=" + birth +
                '}';
    }
}
