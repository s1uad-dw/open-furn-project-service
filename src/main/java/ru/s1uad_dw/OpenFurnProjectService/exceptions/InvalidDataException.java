package ru.s1uad_dw.OpenFurnProjectService.exceptions;

public class InvalidDataException extends RuntimeException{
    public InvalidDataException(String message) {
        super(message);
    }
}
