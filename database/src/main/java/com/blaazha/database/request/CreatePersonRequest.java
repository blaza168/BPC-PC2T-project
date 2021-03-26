package com.blaazha.database.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class CreatePersonRequest {
    private final String firstname;
    private final String lastname;
    private final Date birth;
}
