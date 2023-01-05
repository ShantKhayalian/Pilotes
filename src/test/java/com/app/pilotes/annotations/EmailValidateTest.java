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

class EmailValidateTest {


    @Test
    void testIsValid() {
        EmailValidate emailValidate = new EmailValidate();
        ClockProvider clockProvider = mock(ClockProvider.class);
        assertTrue(emailValidate.isValid("jane.doe@example.org",
                new ConstraintValidatorContextImpl(clockProvider, PathImpl.createRootPath(), null,
                        "Constraint Validator Payload", ExpressionLanguageFeatureLevel.DEFAULT,
                        ExpressionLanguageFeatureLevel.DEFAULT)));
    }


    @Test
    void testIsValid2() {
        EmailValidate emailValidate = new EmailValidate();
        ClockProvider clockProvider = mock(ClockProvider.class);
        assertThrows(ApplicationExceptions.class,
                () -> emailValidate.isValid(
                        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
                        new ConstraintValidatorContextImpl(clockProvider, PathImpl.createRootPath(), null,
                                "Constraint Validator Payload", ExpressionLanguageFeatureLevel.DEFAULT,
                                ExpressionLanguageFeatureLevel.DEFAULT)));
    }


    @Test
    void testIsValid3() {
        EmailValidate emailValidate = new EmailValidate();
        ClockProvider clockProvider = mock(ClockProvider.class);
        assertThrows(ApplicationExceptions.class,
                () -> emailValidate.isValid("",
                        new ConstraintValidatorContextImpl(clockProvider, PathImpl.createRootPath(), null,
                                "Constraint Validator Payload", ExpressionLanguageFeatureLevel.DEFAULT,
                                ExpressionLanguageFeatureLevel.DEFAULT)));
    }
}

