package org.blaazha.application.service;

import com.blaaazha.domain.models.Teacher;
import org.blaazha.application.viewmodel.TeacherViewModel;

import java.util.Collection;
import java.util.Date;

public interface TeacherService {
    Teacher createTeacher(String firstname, String lastname, Date birth);
    Teacher getTeacher(int id);
    void deleteTeacher(int id);
    Collection<Teacher> getStudentsTeacher(int studentId);
    TeacherViewModel getTeacherDetails(int teacherId);

    void assignStudent(int teacherId, int studentId);
    void removeStudent(int teacherId, int studentId);
}
