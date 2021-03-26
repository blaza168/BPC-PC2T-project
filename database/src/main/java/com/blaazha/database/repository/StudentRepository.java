package com.blaazha.database.repository;

import com.blaaazha.domain.models.Student;
import com.blaazha.database.request.CreatePersonRequest;

public interface StudentRepository {
    Student createStudent(CreatePersonRequest request);
}
