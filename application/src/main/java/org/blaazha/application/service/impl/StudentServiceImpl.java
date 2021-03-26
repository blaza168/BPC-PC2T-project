package org.blaazha.application.service.impl;

import com.blaaazha.domain.models.Student;
import com.blaazha.database.repository.StudentRepository;
import com.blaazha.database.request.CreatePersonRequest;
import com.blaazha.database.request.student.AddMarkRequest;
import org.blaazha.application.service.StudentService;

import javax.inject.Inject;
import java.util.Date;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Inject
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(String firstname, String lastname, Date birth) {
        final CreatePersonRequest request = new CreatePersonRequest(firstname, lastname, birth);
        return studentRepository.createStudent(request);
    }

    @Override
    public void addMark(int studentId, int mark) {
        AddMarkRequest request = new AddMarkRequest(studentId, mark);
        this.studentRepository.addStudentMark(request);
    }

    @Override
    public void deleteStudent(int id) {
        this.studentRepository.deleteStudent(id);
    }
}
