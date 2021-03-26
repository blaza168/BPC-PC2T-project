package com.blaazha.UI.action.impl;

import com.blaaazha.domain.models.Student;
import com.blaazha.UI.action.Action;
import com.blaazha.UI.action.subaction.LoadPersonSubaction;
import org.blaazha.application.service.StudentService;

import javax.inject.Inject;
import java.util.Scanner;

public class CreateStudentAction implements Action {

    private final Scanner scanner;
    private final StudentService studentService;
    private final LoadPersonSubaction loadPersonSubaction;

    @Inject
    public CreateStudentAction(
            Scanner scanner,
            StudentService studentService,
            LoadPersonSubaction loadPersonSubaction
    ) {
        this.scanner = scanner;
        this.studentService = studentService;
        this.loadPersonSubaction = loadPersonSubaction;
    }


    @Override
    public void run() {
        System.out.println("Creating student");
        LoadPersonSubaction.PersonAttributes attributes = loadPersonSubaction.loadPerson();
        Student student = studentService.createStudent(attributes.getFirstname(), attributes.getLastname(), attributes.getDate());
        System.out.println("Success");
        System.out.println("Enjoy your student");
        System.out.println(student);
    }
}
