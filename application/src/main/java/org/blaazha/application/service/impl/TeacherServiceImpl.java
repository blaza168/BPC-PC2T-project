package org.blaazha.application.service.impl;

import com.blaaazha.domain.models.Teacher;
import com.blaazha.database.repository.StudentRepository;
import com.blaazha.database.repository.StudentTeacherJoinRepository;
import com.blaazha.database.repository.TeacherRepository;
import com.blaazha.database.request.CreatePersonRequest;
import org.blaazha.application.service.TeacherService;
import org.blaazha.application.viewmodel.TeacherViewModel;
import javax.inject.Inject;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

public class TeacherServiceImpl implements TeacherService {

    private final static int STUDENT_MONEY = 2000;
    private final static int SCHOLARSHIP_BONUS = 500;

    private final TeacherRepository teacherRepository;
    private final StudentTeacherJoinRepository studentTeacherJoinRepository;
    private final StudentRepository studentRepository;

    @Inject
    public TeacherServiceImpl(
            TeacherRepository teacherRepository,
            StudentTeacherJoinRepository studentTeacherJoinRepository,
            StudentRepository studentRepository
    ) {
        this.teacherRepository = teacherRepository;
        this.studentTeacherJoinRepository = studentTeacherJoinRepository;
        this.studentRepository = studentRepository;
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
    public Collection<Teacher> getTeachers() {
        return this.teacherRepository.listTeachers();
    }

    @Override
    public void deleteTeacher(int id) {
        this.teacherRepository.deleteTeacher(id);
    }

    @Override
    public Collection<Teacher> getStudentsTeacher(int studentId) {
        Collection<Integer> teacherIds = this.studentTeacherJoinRepository.getStudentTeachers(studentId);
        return this.teacherRepository.getTeachers(teacherIds);
    }

    @Override
    public TeacherViewModel getTeacherDetails(int teacherId) {
        Teacher teacher = this.teacherRepository.getTeacher(teacherId).build();
        Collection<Integer> studentsIds = this.studentTeacherJoinRepository.getTeachersStudents(teacherId);
        Map<Integer, Float> studentsStudyAvg = this.studentRepository.getStudentsStudyAverage(studentsIds);
        int money = 0;

        for (Map.Entry<Integer, Float> entry: studentsStudyAvg.entrySet()) {
            money += STUDENT_MONEY;

            if (entry.getValue() <= 1.5) {
                money += SCHOLARSHIP_BONUS;
            }
        }

        return new TeacherViewModel(teacher.getId(), teacher.getFirstname(), teacher.getSurname(), teacher.getBirth(), money);
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
