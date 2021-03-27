package com.blaazha.UI.action.impl;

import com.blaazha.UI.action.Action;
import org.blaazha.application.service.TeacherService;
import org.blaazha.application.viewmodel.TeacherViewModel;
import javax.inject.Inject;
import java.util.List;

public class SurnameSortedTeacherListAction implements Action {

    private final TeacherService teacherService;

    @Inject
    public SurnameSortedTeacherListAction(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Override
    public void run() {
        System.out.println("Listing teachers sorted by lastname");

        List<TeacherViewModel> teacherViewModelList = this.teacherService.getTeachersSortedByLastname();

        for (TeacherViewModel viewModel: teacherViewModelList) {
            System.out.println(viewModel);
        }
    }
}
