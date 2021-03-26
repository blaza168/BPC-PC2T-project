package com.blaazha.database.request.student;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddMarkRequest {
    private final int studentId;
    private final int mark;
}
