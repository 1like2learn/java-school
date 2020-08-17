package com.lambdaschool.schools.models;

public class ValidationError {

    /**Fields**/
    private String Code;
    private String message;

    /**Getters and Setters**/
    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ValidationError{" + "Code:'" + Code + '\'' + ", message:'" + message + '\'' + '}';
    }
}
