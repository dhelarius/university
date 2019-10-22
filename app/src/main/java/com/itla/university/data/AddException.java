package com.itla.university.data;

public class AddException extends Exception {

    private long code;

    public AddException(long code) {
        this.code = code;
    }

    @Override
    public String getMessage() {

        String message = "";

        if(code <= 0){
            message = "Error al crear";
        }

        return message;
    }
}
