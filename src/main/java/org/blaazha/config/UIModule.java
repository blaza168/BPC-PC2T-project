package org.blaazha.config;

import com.blaazha.UI.action.Action;
import com.blaazha.UI.action.impl.*;
import com.blaazha.UI.screen.Screen;
import com.blaazha.UI.screen.impl.ActionsScreen;
import com.blaazha.UI.screen.impl.EndScreen;
import com.blaazha.UI.screen.impl.WelcomeScreen;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import java.util.Scanner;

public class UIModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(Scanner.class).toInstance(new Scanner(System.in));

        // screens
        bind(Screen.class).annotatedWith(Names.named("welcome")).to(WelcomeScreen.class);
        bind(Screen.class).annotatedWith(Names.named("end")).to(EndScreen.class);
        bind(Screen.class).annotatedWith(Names.named("actions")).to(ActionsScreen.class);

        // actions
        bind(Action.class).annotatedWith(Names.named("create-student")).to(CreateStudentAction.class);
        bind(Action.class).annotatedWith(Names.named("create-teacher")).to(CreateTeacherAction.class);
        bind(Action.class).annotatedWith(Names.named("mark")).to(AddMarkAction.class);
        bind(Action.class).annotatedWith(Names.named("remove-student")).to(RemoveStudentAction.class);
        bind(Action.class).annotatedWith(Names.named("remove-teacher")).to(RemoveTeacherAction.class);
        bind(Action.class).annotatedWith(Names.named("student-teachers")).to(StudentsTeachersAction.class);
        bind(Action.class).annotatedWith(Names.named("assign-student")).to(AssignStudentToTeacherAction.class);
        bind(Action.class).annotatedWith(Names.named("unassign-student")).to(RemoveStudentFromTeacherAction.class);
        bind(Action.class).annotatedWith(Names.named("detail-student")).to(StudentDetailAction.class);
        bind(Action.class).annotatedWith(Names.named("detail-teacher")).to(TeacherDetailsAction.class);
        bind(Action.class).annotatedWith(Names.named("list-teachers")).to(ListTeachersAction.class);
        bind(Action.class).annotatedWith(Names.named("surname-teachers")).to(SurnameSortedTeacherListAction.class);
        bind(Action.class).annotatedWith(Names.named("surname-students")).to(SurnameSortedStudentListAction.class);
        bind(Action.class).annotatedWith(Names.named("budget")).to(BudgetInfoAction.class);
    }
}
