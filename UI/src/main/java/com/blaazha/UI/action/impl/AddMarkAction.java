package com.blaazha.UI.action.impl;

import com.blaazha.UI.action.Action;
import org.blaazha.application.service.StudentService;

import javax.inject.Inject;
import java.util.Scanner;

public class AddMarkAction implements Action {

    private final Scanner scanner;
    private final StudentService studentService;

    @Inject
    public AddMarkAction(Scanner scanner, StudentService studentService) {
        this.scanner = scanner;
        this.studentService = studentService;
    }


    @Override
    public void run() {
        System.out.println("Adding mark");

        System.out.print("Enter student id: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // drop newline

        System.out.print("Enter mark: ");
        int mark = scanner.nextInt();
        scanner.nextLine(); // drop newline

        studentService.addMark(studentId, mark);
        System.out.println("success");
    }
}
