CREATE TABLE students_teachers (
        student_id          INT NOT NULL,
        teacher_id          INT NOT NULL,

        CONSTRAINT FK_student_id FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE,
        CONSTRAINT FK_teacher_id FOREIGN KEY (teacher_id) REFERENCES teachers(id) ON DELETE CASCADE,
        CONSTRAINT  index_person_pair UNIQUE unq_pair (student_id, teacher_id)
) CHARACTER SET 'UTF8mb4' COLLATE 'utf8mb4_unicode_ci';