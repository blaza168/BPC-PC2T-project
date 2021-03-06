package org.blaazha.application.service.impl;

import com.blaaazha.domain.models.Student;
import com.blaaazha.domain.models.base.Person;
import com.blaazha.database.repository.StudentRepository;
import com.blaazha.database.repository.StudentTeacherJoinRepository;
import com.blaazha.database.request.CreatePersonRequest;
import com.blaazha.database.request.student.AddMarkRequest;
import org.blaazha.application.service.StudentService;
import org.blaazha.application.viewmodel.StudentViewModel;

import javax.inject.Inject;
import java.util.*;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {

    private static final int SCHOLARSHIP = 5000;

    private final StudentRepository studentRepository;
    private final StudentTeacherJoinRepository studentTeacherJoinRepository;

    @Inject
    public StudentServiceImpl(StudentRepository studentRepository, StudentTeacherJoinRepository studentTeacherJoinRepository) {
        this.studentRepository = studentRepository;
        this.studentTeacherJoinRepository = studentTeacherJoinRepository;
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

    @Override
    public List<StudentViewModel> listStudentsSortedByLastname() {
        List<Student> students = this.studentRepository.listStudentsSurnameSorted();
        Collection<Integer> studentIds = students.stream().map(Person::getId).collect(Collectors.toList());
        Map<Integer, Float> studyAvg = this.studentRepository.getStudentsStudyAverage(studentIds);

        List<StudentViewModel> result = new ArrayList<>();

        for (Student student: students) {
            int money = studyAvg.get(student.getId()) <= 1.5 ? SCHOLARSHIP : 0;
            result.add(new StudentViewModel(student.getId(), student.getFirstname(), student.getSurname(), student.getBirth(), money));
        }

        return result;
    }

    @Override
    public StudentViewModel getStudentDetails(int studentId) {
        Student student = this.studentRepository.getStudent(studentId).build();
        float studyAvg = this.studentRepository.getStudentStudyAverage(studentId);
        int money = studyAvg <= 1.5 ? SCHOLARSHIP : 0;

        return new StudentViewModel(student.getId(), student.getFirstname(), student.getSurname(), student.getBirth(), money);
    }
}
