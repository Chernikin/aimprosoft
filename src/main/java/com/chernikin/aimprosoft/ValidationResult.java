package com.chernikin.aimprosoft;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {

    private List<String> errorMessages = new ArrayList<>();

    public void addErrorMessage(String msg) {
        errorMessages.add(msg);
    }

    public boolean hasErrors() {
        return !errorMessages.isEmpty();
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }
}
