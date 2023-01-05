package com.app.pilotes.annotations;

import com.app.pilotes.exceptions.ApplicationExceptions;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class EmailValidate implements ConstraintValidator<ValidateEmailInput, String> {

    @Override
    public void initialize(ValidateEmailInput constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }


    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        boolean isValid = StringUtils.isBlank(email);
        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pat = Pattern.compile(regex);
        isValid = pat.matcher(email).matches();

        if (!isValid) throw new ApplicationExceptions("Invalid Email");
        return true;
    }

}