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

    private final Scanner scanner;

    @Inject
    public UI(
            @Named("welcome") Screen welcomeScreen,
            @Named("end") Screen endScreen,
            @Named("actions") Screen actionsScreen,
            @Named("create-student") Action createStudentAction,
            @Named("create-teacher") Action createTeacherAction,
            @Named("mark") Action markAction,
            Scanner scanner
    ) {
        this.welcomeScreen = welcomeScreen;
        this.endScreen = endScreen;
        this.actionsScreen = actionsScreen;
        this.createStudentAction = createStudentAction;
        this.createTeacherAction = createTeacherAction;
        this.markAction = markAction;
        this.scanner = scanner;
    }

    public void run() {
        welcomeScreen.display();

        scanner.nextLine();
        ScreenUtil.clearScreen();

        int option = 0;

        while (option != 9) {
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
            }
        }

        endScreen.display();
    }

}
