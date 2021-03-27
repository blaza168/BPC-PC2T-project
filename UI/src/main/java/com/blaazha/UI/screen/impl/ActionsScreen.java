package com.blaazha.UI.screen.impl;

import com.blaazha.UI.screen.Screen;

public class ActionsScreen implements Screen {
    @Override
    public void display() {
        System.out.println("Tell me, what do you want to do here ?\n" +
                "You have only these options:\n" +
                "1 --- create student\n" +
                "2 --- create teacher\n" +
                "3 --- add mark to student\n" +
                "4 --- remove student\n" +
                "5 --- remove teacher\n" +
                "6 --- list teachers assigned to student\n" +
                "7 --- assign student to teacher\n" +
                "8 --- remove student from teacher\n" +
                "9 --- show student details\n" +
                "10 -- show teacher details\n" +
                "11 -- list teachers\n" +
                "12 -- list teachers sorted by lastname\n" +
                "13 -- list students sorted by lastname\n" +
                "15 --- exit (best option)");
    }
}
