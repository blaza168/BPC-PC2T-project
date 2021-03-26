package com.blaazha.database.repository;

import com.blaaazha.domain.models.Student;
import com.blaazha.database.request.CreatePersonRequest;
import com.blaazha.database.request.student.AddMarkRequest;
import java.util.Collection;

public interface StudentRepository {

    Student createStudent(CreatePersonRequest request);
    Student.StudentBuilder getStudent(int id);
    Collection<Student> getStudents(Collection<Integer> ids);
    Collection<Student> getStudentsByStudyAverage(Collection<Integer> studentIds);
    void deleteStudent(int id);

    void addStudentMark(AddMarkRequest request);
}
