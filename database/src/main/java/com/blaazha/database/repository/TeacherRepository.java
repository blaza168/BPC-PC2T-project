package com.blaazha.database.repository;

import com.blaaazha.domain.models.Teacher;
import com.blaazha.database.request.CreatePersonRequest;

public interface TeacherRepository {
    Teacher createTeacher(CreatePersonRequest request);
    Teacher.TeacherBuilder getTeacher(int id);
}
