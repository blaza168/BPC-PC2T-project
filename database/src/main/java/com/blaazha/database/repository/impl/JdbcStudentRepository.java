package com.blaazha.database.repository.impl;

import com.blaaazha.domain.models.Student;
import com.blaazha.database.repository.StudentRepository;
import com.blaazha.database.request.CreatePersonRequest;
import com.blaazha.database.util.SQLDateUtil;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import javax.inject.Inject;

public class JdbcStudentRepository implements StudentRepository {

    private static ResultSetMapper<Student> STUDENT_MAPPER = (i, rs, ctx) ->
        new Student(rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getDate("birth"));

    private final DBI dbi;

    @Inject
    public JdbcStudentRepository(DBI dbi) {
        this.dbi = dbi;
    }

    @Override
    public Student createStudent(CreatePersonRequest request) {
        try (Handle h = dbi.open()) {
            int insertedId = h.createStatement("INSERT INTO students (first_name, last_name, birth) VALUES (:first_name,:last_name,:date)")
                    .bind("first_name", request.getFirstname())
                    .bind("last_name", request.getLastname())
                    .bind("date", SQLDateUtil.toSqlFormat(request.getBirth()))
                    .executeAndReturnGeneratedKeys("id")
                    .first();

        }
        return null;
    }
}
