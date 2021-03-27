package com.blaazha.UI.action.impl;

import com.blaaazha.domain.models.Teacher;
import com.blaazha.UI.action.Action;
import org.blaazha.application.service.TeacherService;
import javax.inject.Inject;
import java.util.Collection;

public class ListTeachersAction implements Action {

    private final TeacherService teacherService;

    @Inject
    public ListTeachersAction(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Override
    public void run() {
        System.out.println("Listing teachers");

        Collection<Teacher> teachers = this.teacherService.getTeachers();

        for (Teacher teacher: teachers) {
            System.out.println(teacher);
        }
    }
}
