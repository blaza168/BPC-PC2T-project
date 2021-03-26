package org.blaazha.application.service.impl;

import com.blaaazha.domain.models.Teacher;
import com.blaazha.database.repository.StudentTeacherJoinRepository;
import com.blaazha.database.repository.TeacherRepository;
import com.blaazha.database.request.CreatePersonRequest;
import org.blaazha.application.service.TeacherService;
import javax.inject.Inject;
import java.util.Date;

public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final StudentTeacherJoinRepository studentTeacherJoinRepository;

    @Inject
    public TeacherServiceImpl(TeacherRepository teacherRepository, StudentTeacherJoinRepository studentTeacherJoinRepository) {
        this.teacherRepository = teacherRepository;
        this.studentTeacherJoinRepository = studentTeacherJoinRepository;
    }

    @Override
    public Teacher createTeacher(String firstname, String lastname, Date birth) {
        CreatePersonRequest request = new CreatePersonRequest(firstname, lastname, birth);
        return this.teacherRepository.createTeacher(request);
    }

    @Override
    public Teacher getTeacher(int id) {
        return this.teacherRepository.getTeacher(id).build();
    }

    @Override
    public void assignStudent(int teacherId, int studentId) {
        this.studentTeacherJoinRepository.addStudentToTeacher(studentId, teacherId);
    }

    @Override
    public void removeStudent(int teacherId, int studentId) {
        this.studentTeacherJoinRepository.removeStudentFromTeacher(studentId, teacherId);
    }
}
