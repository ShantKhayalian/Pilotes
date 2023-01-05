package com.app.pilotes.annotations;

import com.app.pilotes.exceptions.ApplicationExceptions;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PilotesValidator implements ConstraintValidator<ValidatePilotsNumber, Integer> {
    @Override
    public void initialize(ValidatePilotsNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        boolean isValid = value >= 0 && !Character.isAlphabetic(value) && value < 16 && value % 5 == 0;
        if (!isValid) throw new ApplicationExceptions("Please check the Pilotes order.");
        return true;

    }
}
