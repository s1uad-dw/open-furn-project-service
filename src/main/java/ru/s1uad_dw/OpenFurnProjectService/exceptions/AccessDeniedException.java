package ru.s1uad_dw.OpenFurnProjectService.exceptions;

public class AccessDeniedException extends RuntimeException{
    public AccessDeniedException(String message) {
        super(message);
    }
}