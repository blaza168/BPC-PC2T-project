package com.blaazha.UI.action.impl;

import com.blaaazha.domain.models.Student;
import com.blaazha.UI.action.Action;
import org.blaazha.application.service.StudentService;
import org.blaazha.application.viewmodel.StudentViewModel;

import javax.inject.Inject;
import java.util.List;

public class SurnameSortedStudentListAction implements Action {

    private final StudentService studentService;

    @Inject
    public SurnameSortedStudentListAction(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void run() {
        System.out.println("Listing students by lastname");

        List<StudentViewModel> students = this.studentService.listStudentsSortedByLastname();

        for (StudentViewModel viewModel: students) {
            System.out.println(viewModel);
        }
    }
}
