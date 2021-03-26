CREATE TABLE students (
                           id                INT auto_increment PRIMARY KEY NOT NULL,
                           first_name        VARCHAR(50)    NOT NULL,
                           last_name         VARCHAR(50)    NOT NULL,
                           birth             DATETIME       NOT NULL,
                           average           DECIMAL(3,2)   DEFAULT NULL,
                           CONSTRAINT  index_unique_student UNIQUE unq_student (first_name, last_name, birth)
) CHARACTER SET 'UTF8mb4' COLLATE 'utf8mb4_unicode_ci';

CREATE TABLE teachers (
                          id                INT auto_increment PRIMARY KEY NOT NULL,
                          first_name        VARCHAR(50)    NOT NULL,
                          last_name         VARCHAR(50)    NOT NULL,
                          birth             DATETIME       NOT NULL,
                          CONSTRAINT  index_unique_teacher UNIQUE unq_teacher (first_name, last_name, birth)
) CHARACTER SET 'UTF8mb4' COLLATE 'utf8mb4_unicode_ci';