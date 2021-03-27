package com.blaazha.database.repository.impl;

import com.blaaazha.domain.models.Teacher;
import com.blaazha.database.repository.TeacherRepository;
import com.blaazha.database.request.CreatePersonRequest;
import com.blaazha.database.util.SQLDateUtil;
import com.google.common.base.Joiner;
import lombok.extern.slf4j.Slf4j;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.util.IntegerColumnMapper;
import javax.inject.Inject;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Slf4j
public class JdbcTeacherRepository implements TeacherRepository {

    private static final Joiner COMMA_JOINER = Joiner.on(",").skipNulls();

    private static final ResultSetMapper<Teacher.TeacherBuilder> TEACHER_BUILDER_MAPPER = (i, rs, ctx) ->
            Teacher.builder().id(rs.getInt("id"))
                    .firstname(rs.getString("first_name"))
                    .surname(rs.getString("last_name"))
                    .birth(rs.getDate("birth"));

    private static final ResultSetMapper<Teacher> TEACHER_MAPPER = (i, rs, ctx) ->
            new Teacher(rs.getInt("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getDate("birth"));

    private final DBI dbi;

    @Inject
    public JdbcTeacherRepository(DBI dbi) {
        this.dbi = dbi;
    }

    @Override
    public Teacher createTeacher(CreatePersonRequest request) {
        try (Handle h = dbi.open()) {
            int insertedId = h.createStatement("INSERT INTO teachers (first_name, last_name, birth) VALUES (:first_name,:last_name,:date)")
                    .bind("first_name", request.getFirstname())
                    .bind("last_name", request.getLastname())
                    .bind("date", SQLDateUtil.toSqlFormat(request.getBirth()))
                    .executeAndReturnGeneratedKeys(IntegerColumnMapper.PRIMITIVE)
                    .first();

            return this.getTeacher(insertedId).build();
        } catch (Exception e) {
            log.error("Creating student failed", e);
            throw e;
        }
    }

    @Override
    public Teacher.TeacherBuilder getTeacher(int id) {
        try (Handle h = dbi.open()) {
            return h.createQuery("SELECT * FROM teachers WHERE id = :id")
                    .bind("id", id)
                    .map(TEACHER_BUILDER_MAPPER)
                    .first();
        } catch (Exception e) {
            log.error("Retrieving student failed", e);
            throw e;
        }
    }

    @Override
    public Collection<Teacher> getTeachers(Collection<Integer> ids) {
        try (Handle h = dbi.open()) {
            Query<Map<String, Object>> query = h.createQuery("SELECT * FROM teachers WHERE id IN (" +
                    COMMA_JOINER.join(Collections.nCopies(ids.size(), "?")) + ")");

            int position = 0;
            for (int id: ids) {
                query.bind(position, id);
                position++;
            }

            return query.map(TEACHER_MAPPER).list();
        } catch (Exception e) {
            log.error("Retrieving teachers failed", e);
            throw e;
        }
    }

    @Override
    public Collection<Teacher> listTeachers() {
        try (Handle h = dbi.open()) {
            return h.createQuery("SELECT id, first_name, last_name, birth FROM teachers " +
                    "ORDER BY (SELECT COUNT(*) FROM students_teachers WHERE teacher_id = teachers.id) DESC")
                    .map(TEACHER_MAPPER)
                    .list();
        } catch (Exception e) {
            log.error("Listing teachers failed", e);
            throw e;
        }
    }

    @Override
    public List<Teacher> listTeachersLastnameSorted() {
        try (Handle h = dbi.open()) {
            return h.createQuery("SELECT * FROM teachers ORDER BY last_name")
                    .map(TEACHER_MAPPER)
                    .list();
        } catch (Exception e) {
            log.error("Retrieving sorted teachers failed", e);
            throw e;
        }
    }

    @Override
    public void deleteTeacher(int id) {
        try (Handle h = dbi.open()) {
            h.update("DELETE FROM teachers WHERE id = ?", id);
        } catch (Exception e) {
            log.error("Deleting teacher failed", e);
            throw e;
        }
    }

}
