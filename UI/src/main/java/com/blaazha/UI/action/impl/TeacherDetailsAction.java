package com.blaazha.UI.action.impl;

import com.blaazha.UI.action.Action;
import org.blaazha.application.service.TeacherService;
import org.blaazha.application.viewmodel.StudentViewModel;
import org.blaazha.application.viewmodel.TeacherViewModel;

import javax.inject.Inject;
import java.util.Scanner;

public class TeacherDetailsAction implements Action {

    private final Scanner scanner;
    private final TeacherService teacherService;

    @Inject
    public TeacherDetailsAction(Scanner scanner, TeacherService teacherService) {
        this.scanner = scanner;
        this.teacherService = teacherService;
    }


    @Override
    public void run() {
        System.out.println("Teacher details");

        System.out.print("Enter teacher id: ");
        int teacherId = scanner.nextInt();
        scanner.nextLine();

        TeacherViewModel teacherDetails = this.teacherService.getTeacherDetails(teacherId);

        System.out.println(teacherDetails);
    }
}
