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

        // screens
        bind(Screen.class).annotatedWith(Names.named("welcome")).to(WelcomeScreen.class);
        bind(Screen.class).annotatedWith(Names.named("end")).to(EndScreen.class);
        bind(Screen.class).annotatedWith(Names.named("actions")).to(ActionsScreen.class);
        bind(Scanner.class).toInstance(new Scanner(System.in));

        // actions
        bind(Action.class).annotatedWith(Names.named("create-student")).to(CreateStudentAction.class);
        bind(Action.class).annotatedWith(Names.named("create-teacher")).to(CreateTeacherAction.class);
        bind(Action.class).annotatedWith(Names.named("mark")).to(AddMarkAction.class);
        bind(Action.class).annotatedWith(Names.named("remove-student")).to(RemoveStudentAction.class);
        bind(Action.class).annotatedWith(Names.named("remove-teacher")).to(RemoveTeacherAction.class);
    }
}
