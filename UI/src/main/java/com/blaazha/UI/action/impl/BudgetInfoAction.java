package com.blaazha.UI.action.impl;

import com.blaaazha.domain.models.Teacher;
import com.blaazha.UI.action.Action;
import org.blaazha.application.service.StudentService;
import org.blaazha.application.service.TeacherService;
import org.blaazha.application.viewmodel.StudentViewModel;
import org.blaazha.application.viewmodel.TeacherViewModel;

import javax.inject.Inject;
import java.util.List;

public class BudgetInfoAction implements Action {

    private final StudentService studentService;
    private final TeacherService teacherService;

    @Inject
    public BudgetInfoAction(StudentService studentService, TeacherService teacherService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
    }


    @Override
    public void run() {
        // this is disgusting
        List<StudentViewModel> studentViewModels = this.studentService.listStudentsSortedByLastname();
        List<TeacherViewModel> teacherViewModels = this.teacherService.getTeachersSortedByLastname();

        int budget = 0;

        for (StudentViewModel studentViewModel: studentViewModels) {
            budget += studentViewModel.getMoney();
        }

        for (TeacherViewModel teacherViewModel: teacherViewModels) {
            budget += teacherViewModel.getMoney();
        }

        System.out.println("Budget for 1 month: " + budget);
    }
}
