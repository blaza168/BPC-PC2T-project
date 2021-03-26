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
                "9 --- exit (best option)");
    }
}
