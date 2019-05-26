package com.chernikin.aimprosoft;

public interface Validator<T> {

    ValidationResult validate(T object);
}
