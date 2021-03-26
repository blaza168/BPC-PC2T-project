package com.blaazha.UI.action.impl;

import com.blaaazha.domain.models.Student;
import com.blaazha.UI.action.Action;
import com.blaazha.UI.action.subaction.LoadPersonSubaction;
import org.blaazha.application.service.StudentService;
import org.blaazha.application.service.TeacherService;

import javax.inject.Inject;
import java.util.Scanner;

public class CreateStudentAction implements Action {

    private final Scanner scanner;
    private final StudentService studentService;
    private final TeacherService teacherService;
    private final LoadPersonSubaction loadPersonSubaction;

    @Inject
    public CreateStudentAction(
            Scanner scanner,
            StudentService studentService,
            TeacherService teacherService,
            LoadPersonSubaction loadPersonSubaction
    ) {
        this.scanner = scanner;
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.loadPersonSubaction = loadPersonSubaction;
    }


    @Override
    public void run() {
        System.out.println("Creating student");
        LoadPersonSubaction.PersonAttributes attributes = loadPersonSubaction.loadPerson();

        System.out.print("Enter id of teacher for this student: ");
        int teacherId = scanner.nextInt();
        scanner.nextLine(); // drop newline

        if (teacherService.getTeacher(teacherId) == null) {
            System.out.println("Teacher does not exists. Aborting.");
            return;
        }

        Student student = studentService.createStudent(attributes.getFirstname(), attributes.getLastname(), attributes.getDate());
        teacherService.assignStudent(teacherId, student.getId());

        System.out.println("Success");
        System.out.println("Enjoy your student");
        System.out.println(student);
    }
}
