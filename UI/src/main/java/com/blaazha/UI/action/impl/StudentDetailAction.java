package com.blaazha.UI.action.impl;

import com.blaazha.UI.action.Action;
import org.blaazha.application.service.StudentService;
import org.blaazha.application.viewmodel.StudentViewModel;

import javax.inject.Inject;
import java.util.Scanner;

public class StudentDetailAction implements Action {

    private final Scanner scanner;
    private final StudentService studentService;

    @Inject
    public StudentDetailAction(Scanner scanner, StudentService studentService) {
        this.scanner = scanner;
        this.studentService = studentService;
    }

    @Override
    public void run() {
        System.out.println("Student details");

        System.out.print("Enter student id: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        StudentViewModel studentViewModel = this.studentService.getStudentDetails(studentId);

        System.out.println(studentViewModel);
    }
}
