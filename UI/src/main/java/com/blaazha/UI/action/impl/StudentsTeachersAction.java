package com.blaazha.UI.action.impl;

import com.blaaazha.domain.models.Teacher;
import com.blaazha.UI.action.Action;
import com.blaazha.database.repository.TeacherRepository;
import org.blaazha.application.service.TeacherService;

import javax.inject.Inject;
import java.util.Collection;
import java.util.Scanner;

public class StudentsTeachersAction implements Action {

    private final Scanner scanner;
    private final TeacherService teacherService;

    @Inject
    public StudentsTeachersAction(Scanner scanner, TeacherService teacherService) {
        this.scanner = scanner;
        this.teacherService = teacherService;
    }

    @Override
    public void run() {
        System.out.println("Listing teachers for student");

        int studentId = scanner.nextInt();
        scanner.nextLine(); // drop newline

        Collection<Teacher> teachers = this.teacherService.getStudentsTeacher(studentId);

        for (Teacher teacher: teachers) {
            System.out.println(teacher);
        }
    }
}
