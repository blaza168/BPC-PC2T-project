package com.blaazha.UI.action.impl;

import com.blaazha.UI.action.Action;
import org.blaazha.application.service.TeacherService;

import javax.inject.Inject;
import java.util.Scanner;

public class RemoveTeacherAction implements Action {

    private final Scanner scanner;
    private final TeacherService teacherService;

    @Inject
    public RemoveTeacherAction(Scanner scanner, TeacherService teacherService) {
        this.scanner = scanner;
        this.teacherService = teacherService;
    }


    @Override
    public void run() {
        System.out.println("Removing teacher");

        System.out.print("Enter teacher id: ");
        int teacherId = scanner.nextInt();
        scanner.nextLine();

        teacherService.deleteTeacher(teacherId);
        System.out.println("success");
    }
}
