package com.blaazha.UI.action.impl;

import com.blaazha.UI.action.Action;
import org.blaazha.application.service.StudentService;
import javax.inject.Inject;
import java.util.Scanner;

public class RemoveStudentAction implements Action {

    private final Scanner scanner;
    private final StudentService studentService;

    @Inject
    public RemoveStudentAction(Scanner scanner, StudentService studentService) {
        this.scanner = scanner;
        this.studentService = studentService;
    }


    @Override
    public void run() {
        System.out.println("Removing student");

        System.out.print("Enter student id: ");
        int teacherId = scanner.nextInt();
        scanner.nextLine();

        studentService.deleteStudent(teacherId);
        System.out.println("success");
    }
}
