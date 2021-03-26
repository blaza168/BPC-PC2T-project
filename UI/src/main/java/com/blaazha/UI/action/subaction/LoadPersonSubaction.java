package com.blaazha.UI.action.subaction;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LoadPersonSubaction {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");

    @Getter
    @AllArgsConstructor
    public static final class PersonAttributes {
        private final String firstname;
        private final String lastname;
        private final Date date;
    }

    private final Scanner scanner;

    @Inject
    public LoadPersonSubaction(Scanner scanner) {
        this.scanner = scanner;
    }

    public PersonAttributes loadPerson() {
        String firstname;
        String lastname;
        Date date = null;

        System.out.print("Enter firstname: ");
        firstname = scanner.nextLine();

        System.out.print("Enter lastname: ");
        lastname = scanner.nextLine();


        while (date == null) {
            try {
                System.out.print("Enter date in format 'dd mm yyyy': ");
                date = dateFormat.parse(scanner.nextLine());
            } catch (ParseException e) {
                System.out.println("WRONG FORMAT!!! TRY IT AGAIN!!");
            }
        }

        return new PersonAttributes(firstname, lastname, date);
    }
}
