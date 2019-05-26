package com.chernikin.aimprosoft.database;

public class DatabaseException extends RuntimeException {

    public DatabaseException() {
    }

    public DatabaseException(Throwable cause) {
        super(cause);
    }

    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
