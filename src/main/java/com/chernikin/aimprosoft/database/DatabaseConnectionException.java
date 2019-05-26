package com.chernikin.aimprosoft.database;

public class DatabaseConnectionException extends DatabaseException {

    public DatabaseConnectionException() {

    }

    public DatabaseConnectionException(Throwable cause) {
        super(cause);
    }

    public DatabaseConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
