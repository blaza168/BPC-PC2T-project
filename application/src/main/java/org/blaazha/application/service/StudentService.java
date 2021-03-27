package org.blaazha.application.service;

import com.blaaazha.domain.models.Student;
import org.blaazha.application.viewmodel.StudentViewModel;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface StudentService {
    Student createStudent(String firstname, String lastname, Date birth);
    void addMark(int studentId, int mark);
    void deleteStudent(int id);

    List<StudentViewModel> listStudentsSortedByLastname();

    StudentViewModel getStudentDetails(int studentId);
}
