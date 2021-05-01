package com.spring.conduit.entities;

import java.util.ArrayList;
import java.util.Arrays;

public class ErrorEntity {
    Errors errors;

    public Errors getErrors() {
        return errors;
    }

    private ErrorEntity(Errors errors) {
        this.errors = errors;
    }
    static class Errors {
        public ArrayList<String> getBody() {
            return body;
        }

        ArrayList<String> body;

        private Errors(ArrayList<String> body) {
            this.body = body;
        }
    }

    public static ErrorEntity from( String... errorMessages) {
        return new ErrorEntity( new Errors(
                new ArrayList<>(Arrays.asList(errorMessages))
        ));
    }
}
