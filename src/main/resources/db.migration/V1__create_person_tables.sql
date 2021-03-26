CREATE TABLE students (
                           id                INT auto_increment PRIMARY KEY NOT NULL,
                           first_name        VARCHAR(50)    NOT NULL,
                           last_name         VARCHAR(50)    NOT NULL,
                           birth             DATETIME       NOT NULL,
                           CONSTRAINT  index_unique_student UNIQUE unq_student (first_name, last_name, birth)
) CHARACTER SET 'UTF8mb4' COLLATE 'utf8mb4_unicode_ci';

CREATE TABLE teachers (
                          id                INT auto_increment PRIMARY KEY NOT NULL,
                          first_name        VARCHAR(50)    NOT NULL,
                          last_name         VARCHAR(50)    NOT NULL,
                          birth             DATETIME       NOT NULL,
                          CONSTRAINT  index_unique_teacher UNIQUE unq_teacher (first_name, last_name, birth)
) CHARACTER SET 'UTF8mb4' COLLATE 'utf8mb4_unicode_ci';

CREATE TABLE student_marks (
                          student_id        INT NOT NULL,
                          mark              INT(3) NOT NULL,

                          CONSTRAINT FK_student_mark FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE
) CHARACTER SET 'UTF8mb4' COLLATE 'utf8mb4_unicode_ci';