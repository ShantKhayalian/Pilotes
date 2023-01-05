package com.app.pilotes.annotations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.app.pilotes.exceptions.ApplicationExceptions;

import javax.validation.ClockProvider;

import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.hibernate.validator.messageinterpolation.ExpressionLanguageFeatureLevel;
import org.junit.jupiter.api.Test;

class StringValidatorTest {

    @Test
    void testIsValid() {
        StringValidator stringValidator = new StringValidator();
        ClockProvider clockProvider = mock(ClockProvider.class);
        assertThrows(ApplicationExceptions.class,
                () -> stringValidator.isValid("42",
                        new ConstraintValidatorContextImpl(clockProvider, PathImpl.createRootPath(), null,
                                "Constraint Validator Payload", ExpressionLanguageFeatureLevel.DEFAULT,
                                ExpressionLanguageFeatureLevel.DEFAULT)));
    }

    @Test
    void testIsValid2() {
        StringValidator stringValidator = new StringValidator();
        ClockProvider clockProvider = mock(ClockProvider.class);
        assertThrows(ApplicationExceptions.class,
                () -> stringValidator.isValid((String) " ",
                        new ConstraintValidatorContextImpl(clockProvider, PathImpl.createRootPath(), null,
                                "Constraint Validator Payload", ExpressionLanguageFeatureLevel.DEFAULT,
                                ExpressionLanguageFeatureLevel.DEFAULT)));
    }

    @Test
    void testIsValid3() {
        StringValidator stringValidator = new StringValidator();
        ClockProvider clockProvider = mock(ClockProvider.class);
        assertTrue(stringValidator.isValid("Value",
                new ConstraintValidatorContextImpl(clockProvider, PathImpl.createRootPath(), null,
                        "Constraint Validator Payload", ExpressionLanguageFeatureLevel.DEFAULT,
                        ExpressionLanguageFeatureLevel.DEFAULT)));
    }


    @Test
    void testIsValid4() {
        StringValidator stringValidator = new StringValidator();
        ClockProvider clockProvider = mock(ClockProvider.class);
        assertThrows(ApplicationExceptions.class,
                () -> stringValidator.isValid("",
                        new ConstraintValidatorContextImpl(clockProvider, PathImpl.createRootPath(), null,
                                "Constraint Validator Payload", ExpressionLanguageFeatureLevel.DEFAULT,
                                ExpressionLanguageFeatureLevel.DEFAULT)));
    }

}

