package ru.s1uad_dw.OpenFurnProjectService.exceptions;

public class TokenExpiredException extends RuntimeException{
    public TokenExpiredException(String message) {
        super(message);
    }
}