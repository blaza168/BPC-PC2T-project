package com.blaazha.UI.action.impl;

import com.blaaazha.domain.models.Teacher;
import com.blaazha.UI.action.Action;
import com.blaazha.UI.action.subaction.LoadPersonSubaction;
import org.blaazha.application.service.TeacherService;
import javax.inject.Inject;

public class CreateTeacherAction implements Action {

    private final TeacherService teacherService;
    private final LoadPersonSubaction loadPersonSubaction;

    @Inject
    public CreateTeacherAction(TeacherService teacherService, LoadPersonSubaction loadPersonSubaction) {
        this.teacherService = teacherService;
        this.loadPersonSubaction = loadPersonSubaction;
    }

    @Override
    public void run() {
        System.out.println("Creating teacher");
        LoadPersonSubaction.PersonAttributes attributes = loadPersonSubaction.loadPerson();
        Teacher teacher = teacherService.createTeacher(attributes.getFirstname(), attributes.getLastname(), attributes.getDate());
        System.out.println("Success");
        System.out.println(teacher);
    }
}
