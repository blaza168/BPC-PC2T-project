package com.blaazha.database.repository.impl;

import com.blaazha.database.repository.StudentTeacherJoinRepository;
import com.blaazha.database.util.SQLDateUtil;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.util.IntegerColumnMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

public class JdbcStudentTeacherJoinRepository implements StudentTeacherJoinRepository {

    private static final Logger log = LoggerFactory.getLogger(JdbcStudentTeacherJoinRepository.class);

    private final DBI dbi;

    @Inject
    public JdbcStudentTeacherJoinRepository(DBI dbi) {
        this.dbi = dbi;
    }

    @Override
    public void addStudentToTeacher(int studentId, int teacherId) {
        try (Handle h = dbi.open()) {
            h.createStatement("INSERT INTO students_teachers (student_id, teacher_id) VALUES (:student_id,:teacher_id)")
                    .bind("student_id", studentId)
                    .bind("teacher_id", teacherId)
                    .execute();
        } catch (Exception e) {
            log.error("Assigning failed", e);
            throw e;
        }
    }

    @Override
    public void removeStudentFromTeacher(int studentId, int teacherId) {
        try (Handle h = dbi.open()) {
            h.createStatement("DELETE FROM students_teachers WHERE student_id = :student_id, teacher_id = :teacher_id")
                    .bind("student_id", studentId)
                    .bind("teacher_id", teacherId)
                    .execute();
        } catch (Exception e) {
            log.error("Removing assignment failed", e);
            throw e;
        }
    }
}
