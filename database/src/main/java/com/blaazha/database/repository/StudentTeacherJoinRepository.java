package com.blaazha.database.repository;

import java.util.Collection;

public interface StudentTeacherJoinRepository {
    void addStudentToTeacher(int studentId, int teacherId);
    void removeStudentFromTeacher(int studentId, int teacherId);
    Collection<Integer> getStudentTeachers(int studentId);
    Collection<Integer> getTeachersStudents(int teacherId);
}
