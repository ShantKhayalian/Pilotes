package com.app.pilotes.annotations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import com.app.pilotes.exceptions.ApplicationExceptions;

import javax.validation.ClockProvider;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.hibernate.validator.messageinterpolation.ExpressionLanguageFeatureLevel;
import org.junit.jupiter.api.Test;

class PhoneValidatorTest {


    @Test
    void testIsValid() {
        PhoneValidator phoneValidator = new PhoneValidator();
        ClockProvider clockProvider = mock(ClockProvider.class);
        assertThrows(ApplicationExceptions.class,
                () -> phoneValidator.isValid("Contact Field",
                        new ConstraintValidatorContextImpl(clockProvider, PathImpl.createRootPath(), null,
                                "Constraint Validator Payload", ExpressionLanguageFeatureLevel.DEFAULT,
                                ExpressionLanguageFeatureLevel.DEFAULT)));
    }


    @Test
    void testIsValid2() {
        PhoneValidator phoneValidator = new PhoneValidator();
        ClockProvider clockProvider = mock(ClockProvider.class);
        assertThrows(ApplicationExceptions.class,
                () -> phoneValidator.isValid(null,
                        new ConstraintValidatorContextImpl(clockProvider, PathImpl.createRootPath(), null,
                                "Constraint Validator Payload", ExpressionLanguageFeatureLevel.DEFAULT,
                                ExpressionLanguageFeatureLevel.DEFAULT)));
    }


    @Test
    void testIsValid3() {
        PhoneValidator phoneValidator = new PhoneValidator();
        ClockProvider clockProvider = mock(ClockProvider.class);
        assertThrows(ApplicationExceptions.class,
                () -> phoneValidator.isValid("9",
                        new ConstraintValidatorContextImpl(clockProvider, PathImpl.createRootPath(), null,
                                "Constraint Validator Payload", ExpressionLanguageFeatureLevel.DEFAULT,
                                ExpressionLanguageFeatureLevel.DEFAULT)));
    }


    @Test
    void testIsValid4() {
        PhoneValidator phoneValidator = new PhoneValidator();
        ClockProvider clockProvider = mock(ClockProvider.class);
        assertThrows(ApplicationExceptions.class,
                () -> phoneValidator.isValid("42",
                        new ConstraintValidatorContextImpl(clockProvider, PathImpl.createRootPath(), null,
                                "Constraint Validator Payload", ExpressionLanguageFeatureLevel.DEFAULT,
                                ExpressionLanguageFeatureLevel.DEFAULT)));
    }
}

