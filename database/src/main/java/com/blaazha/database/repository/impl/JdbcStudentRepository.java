package com.blaazha.database.repository.impl;

import com.blaaazha.domain.models.Student;
import com.blaazha.database.repository.StudentRepository;
import com.blaazha.database.request.CreatePersonRequest;
import com.blaazha.database.request.student.AddMarkRequest;
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
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class JdbcStudentRepository implements StudentRepository {

    private static final Joiner COMMA_JOINER = Joiner.on(",").skipNulls();

    private static final ResultSetMapper<Student.StudentBuilder> STUDENT_BUILDER_MAPPER = (i, rs, ctx) ->
        Student.builder().id(rs.getInt("id"))
                .firstname(rs.getString("first_name"))
                .surname(rs.getString("last_name"))
                .birth(rs.getDate("birth"));

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
                    .executeAndReturnGeneratedKeys(IntegerColumnMapper.PRIMITIVE)
                    .first();

            return this.getStudent(insertedId).build();
        } catch (Exception e) {
            log.error("Creating student failed", e);
            throw e;
        }
    }

    @Override
    public Student.StudentBuilder getStudent(int id) {
        try (Handle h = dbi.open()) {
            return h.createQuery("SELECT * FROM students WHERE id = :id")
                    .bind("id", id)
                    .map(STUDENT_BUILDER_MAPPER)
                    .first();
        } catch (Exception e) {
            log.error("Retrieving student failed", e);
            throw e;
        }
    }

    @Override
    public Collection<Student> getStudents(Collection<Integer> ids) {
        try (Handle h = dbi.open()) {
            Query<Map<String, Object>> query = h.createQuery("SELECT * FROM students WHERE students IN (" +
                    COMMA_JOINER.join(ids.size(), "?") + ")");

            int position = 0;
            for (int id: ids) {
                query.bind(position, id);
                position++;
            }

            return query.map(STUDENT_BUILDER_MAPPER).list().stream().map(Student.StudentBuilder::build).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Retrieving students failed", e);
            throw e;
        }
    }

    @Override
    public Collection<Student> getStudentsByStudyAverage(Collection<Integer> studentIds) {
//        try (Handle h = dbi.open()) {
//            Query<Map<String, Object>> query = h.createQuery("SELECT id FROM student_marks " +
//                    " WHERE student_ids IN (" +
//                    COMMA_JOINER.join(studentIds.size(), "?") +
//                    " ORDER BY AVG(mark)");
//
//            int position = 0;
//            for (int id: studentIds) {
//                query.bind(position, id);
//                position++;
//            }
//
//            List<Integer> idsSorted = query.mapTo(Integer.class).list();
//
//            return query.map(STUDENT_MAPPER).list();
//        } catch (Exception e) {
//            log.error("Retrieving students failed", e);
//            throw e;
//        }
        return null;
    }

    @Override
    public void deleteStudent(int id) {
        try (Handle h = dbi.open()) {
            h.update("DELETE * FROM students WHERE id = ?", id);
        } catch (Exception e) {
            log.error("Deleting student failed", e);
            throw e;
        }
    }

    @Override
    public void addStudentMark(AddMarkRequest request) {
        try (Handle h = dbi.open()) {
            h.createStatement("INSERT INTO student_marks (student_id, mark) VALUES (:student_id, :mark)")
                    .bind("student_id", request.getStudentId())
                    .bind("mark", request.getMark())
                    .execute();
        } catch (Exception e) {
            log.error("Creating student failed", e);
            throw e;
        }
    }
}
