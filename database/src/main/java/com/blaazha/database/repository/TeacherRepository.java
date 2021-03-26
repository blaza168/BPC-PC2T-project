package com.blaazha.database.repository;

import com.blaaazha.domain.models.Teacher;
import com.blaazha.database.request.CreatePersonRequest;

import java.util.Collection;

public interface TeacherRepository {
    Teacher createTeacher(CreatePersonRequest request);
    Teacher.TeacherBuilder getTeacher(int id);
    Collection<Teacher> getTeachers(Collection<Integer> ids);
    void deleteTeacher(int id);
}
