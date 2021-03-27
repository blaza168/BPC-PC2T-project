package org.blaazha.application.service;

import com.blaaazha.domain.models.Teacher;
import org.blaazha.application.viewmodel.TeacherViewModel;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface TeacherService {
    Teacher createTeacher(String firstname, String lastname, Date birth);
    Teacher getTeacher(int id);

    /**
     * Get list of teachers sorted by number of students
     * @return
     */
    Collection<Teacher> getTeachers();
    void deleteTeacher(int id);

    /**
     * Return teachers for student
     * @param studentId
     * @return
     */
    Collection<Teacher> getStudentsTeacher(int studentId);
    TeacherViewModel getTeacherDetails(int teacherId);

    /**
     * Get teacher with students sorted by their study avg
     * @param teacherId
     * @return
     */
    TeacherViewModel getTeacherWithStudents(int teacherId);

    List<TeacherViewModel> getTeachersSortedByLastname();


    void assignStudent(int teacherId, int studentId);
    void removeStudent(int teacherId, int studentId);
}
