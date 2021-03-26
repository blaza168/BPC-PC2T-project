package com.blaazha.database.request;

import lombok.AccessLevel;
import lombok.Getter;

import java.util.Date;

@Getter(AccessLevel.PUBLIC)
public class CreatePersonRequest {
    private final String firstname;
    private final String lastname;
    private final Date birth;

    public CreatePersonRequest(String firstname, String lastname, Date birth) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birth = birth;
    }
}
