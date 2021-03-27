package com.blaaazha.domain.models;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    // Definitely "not" useless test
    @Test
    public void test() {
        int id = 1;
        String name = "Pepa";
        String lastname = "NemaRadFyziku";
        Date birth = new Date();

        Student student = new Student(id, name, lastname, birth);

        assertEquals(name, student.getFirstname());
        assertEquals(lastname, student.getSurname());
        assertEquals(id, student.getId());
    }
}