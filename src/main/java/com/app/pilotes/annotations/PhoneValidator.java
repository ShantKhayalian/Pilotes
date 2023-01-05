package com.app.pilotes.annotations;

import com.app.pilotes.exceptions.ApplicationExceptions;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<ValidatePhoneInput, String> {

    @Override
    public void initialize(ValidatePhoneInput constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String contactField, ConstraintValidatorContext cxt) {
        boolean isValid= contactField != null && contactField.matches("[0-9]+")
                && (contactField.length() > 8) && (contactField.length() < 14);
        if (!isValid) throw new ApplicationExceptions("Invalid Phone number.");
        return true;
    }

}