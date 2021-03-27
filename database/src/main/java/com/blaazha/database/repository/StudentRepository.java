package com.blaazha.database.repository;

import com.blaaazha.domain.models.Student;
import com.blaazha.database.request.CreatePersonRequest;
import com.blaazha.database.request.student.AddMarkRequest;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface StudentRepository {

    Student createStudent(CreatePersonRequest request);
    Student.StudentBuilder getStudent(int id);
    Collection<Student> getStudents(Collection<Integer> ids);
    List<Student> listStudentsSurnameSorted();
    Collection<Student> getStudentsByStudyAverage(Collection<Integer> studentIds);
    void deleteStudent(int id);

    Map<Integer, Float> getStudentsStudyAverage(Collection<Integer> studentIds);
    float getStudentStudyAverage(int studentId);

    void addStudentMark(AddMarkRequest request);
}
