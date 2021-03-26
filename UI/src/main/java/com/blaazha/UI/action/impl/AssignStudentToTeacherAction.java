package com.blaazha.UI.action.impl;

import com.blaazha.UI.action.Action;
import org.blaazha.application.service.TeacherService;
import javax.inject.Inject;
import java.util.Scanner;

public class AssignStudentToTeacherAction implements Action {

    private final Scanner scanner;
    private final TeacherService teacherService;

    @Inject
    public AssignStudentToTeacherAction(Scanner scanner, TeacherService teacherService) {
        this.scanner = scanner;
        this.teacherService = teacherService;
    }

    @Override
    public void run() {
        System.out.println("Assigning student to teacher");

        System.out.print("Enter student id: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter teacher id: ");
        int teacherId = scanner.nextInt();
        scanner.nextLine();

        teacherService.assignStudent(teacherId, studentId);

        System.out.println("Success");
    }
}
