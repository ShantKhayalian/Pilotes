package com.app.pilotes.annotations;

import com.app.pilotes.exceptions.ApplicationExceptions;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringValidator implements ConstraintValidator<ValidateStringInput, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isValid = value.isEmpty() || value.isBlank() || " ".equals(value) || value.length() < 4 || value.length() > 256;
        if (isValid) throw new ApplicationExceptions("Please check your inputs at " + value);
        return true;
    }

    @Override
    public void initialize(ValidateStringInput constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
