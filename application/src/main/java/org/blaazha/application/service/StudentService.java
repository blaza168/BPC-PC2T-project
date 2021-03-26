package org.blaazha.application.service;

import com.blaaazha.domain.models.Student;

import java.util.Date;

public interface StudentService {
    Student createStudent(String firstname, String lastname, Date birth);
    void addMark(int studentId, int mark);
    void deleteStudent(int id);
}
