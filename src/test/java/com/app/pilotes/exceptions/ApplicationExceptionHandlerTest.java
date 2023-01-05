package com.app.pilotes.exceptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.app.pilotes.model.response.ResponseBuilder;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApplicationExceptionHandlerTest {

    @Test
    public void testApplicationExceptions() {
        ApplicationExceptionHandler<Object> applicationExceptionHandler = new ApplicationExceptionHandler<>();
        ResponseEntity<ResponseBuilder<?>> actualApplicationExceptionsResult = applicationExceptionHandler
                .ApplicationExceptions(new ApplicationExceptions("An error occurred"));
        assertTrue(actualApplicationExceptionsResult.hasBody());
        assertTrue(actualApplicationExceptionsResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.EXPECTATION_FAILED, actualApplicationExceptionsResult.getStatusCode());
        ResponseBuilder<?> body = actualApplicationExceptionsResult.getBody();
        assertEquals("An error occurred", body.getData());
        assertFalse(body.getIsSuccess());
        assertEquals(HttpStatus.EXPECTATION_FAILED, body.getHttpStatus());
        assertEquals(417, body.getHttpStatusCode().intValue());
    }

}

