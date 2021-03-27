package com.blaazha.UI;

import com.blaazha.UI.action.Action;
import com.blaazha.UI.screen.Screen;
import com.blaazha.UI.util.ScreenUtil;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Scanner;

public class UI {

    private final Screen welcomeScreen;
    private final Screen endScreen;
    private final Screen actionsScreen;

    private final Action createStudentAction;
    private final Action createTeacherAction;
    private final Action markAction;
    private final Action removeStudentAction;
    private final Action removeTeacherAction;
    private final Action studentTeachersAction;
    private final Action assignStudentAction;
    private final Action unassignStudentAction;
    private final Action studentDetailsAction;
    private final Action teacherDetailsAction;
    private final Action listTeachersAction;
    private final Action surnameSortedStudentListAction;
    private final Action surnameSortedTeachersListAction;
    private final Action budgetInfoAction;

    private final Scanner scanner;

    @Inject
    public UI(
            @Named("welcome") Screen welcomeScreen,
            @Named("end") Screen endScreen,
            @Named("actions") Screen actionsScreen,
            @Named("create-student") Action createStudentAction,
            @Named("create-teacher") Action createTeacherAction,
            @Named("mark") Action markAction,
            @Named("remove-student") Action removeStudentAction,
            @Named("remove-teacher") Action removeTeacherAction,
            @Named("student-teachers") Action studentTeachersAction,
            @Named("assign-student") Action assignStudentAction,
            @Named("unassign-student") Action unassignStudentAction,
            @Named("detail-student") Action studentDetailsAction,
            @Named("detail-teacher") Action teacherDetailsAction,
            @Named("list-teachers") Action listTeachersAction,
            @Named("surname-students") Action surnameSortedStudentListAction,
            @Named("surname-teachers") Action surnameSortedTeachersListAction,
            @Named("budget") Action budgetInfoAction,
            Scanner scanner
    ) {
        this.welcomeScreen = welcomeScreen;
        this.endScreen = endScreen;
        this.actionsScreen = actionsScreen;
        this.createStudentAction = createStudentAction;
        this.createTeacherAction = createTeacherAction;
        this.markAction = markAction;
        this.removeStudentAction = removeStudentAction;
        this.removeTeacherAction = removeTeacherAction;
        this.studentTeachersAction = studentTeachersAction;
        this.assignStudentAction = assignStudentAction;
        this.unassignStudentAction = unassignStudentAction;
        this.studentDetailsAction = studentDetailsAction;
        this.teacherDetailsAction = teacherDetailsAction;
        this.listTeachersAction = listTeachersAction;
        this.surnameSortedStudentListAction = surnameSortedStudentListAction;
        this.surnameSortedTeachersListAction = surnameSortedTeachersListAction;
        this.budgetInfoAction = budgetInfoAction;
        this.scanner = scanner;
    }

    public void run() {
        welcomeScreen.display();

        scanner.nextLine();
        ScreenUtil.clearScreen();

        int option = 0;

        while (option != 15) {
            actionsScreen.display();

            option = scanner.nextInt();
            scanner.nextLine(); // drop newline

            switch (option) {
                case 1:
                    createStudentAction.run();
                    break;
                case 2:
                    createTeacherAction.run();
                    break;
                case 3:
                    markAction.run();
                    break;
                case 4:
                    removeStudentAction.run();
                    break;
                case 5:
                    removeTeacherAction.run();
                    break;
                case 6:
                    studentTeachersAction.run();
                    break;
                case 7:
                    assignStudentAction.run();
                    break;
                case 8:
                    unassignStudentAction.run();
                    break;
                case 9:
                    studentDetailsAction.run();
                    break;
                case 10:
                    teacherDetailsAction.run();
                    break;
                case 11:
                    listTeachersAction.run();
                    break;
                case 12:
                    surnameSortedStudentListAction.run();
                    break;
                case 13:
                    surnameSortedTeachersListAction.run();
                    break;
                case 14:
                    budgetInfoAction.run();
                    break;
            }
        }

        endScreen.display();
    }

}
