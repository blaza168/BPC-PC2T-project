package com.blaazha.database.repository;

public interface StudentTeacherJoinRepository {
    void addStudentToTeacher(int studentId, int teacherId);
    void removeStudentFromTeacher(int studentId, int teacherId);
}
