package com.app.pilotes.model.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class ResponseBuilderTest {

    @Test
    void testConstructor() {
        ResponseBuilder<Object> actualResponseBuilder = new ResponseBuilder<>();
        actualResponseBuilder.setData("Data");
        actualResponseBuilder.setDate(mock(Timestamp.class));
        actualResponseBuilder.setHttpStatus(HttpStatus.CONTINUE);
        actualResponseBuilder.setHttpStatusCode(1);
        actualResponseBuilder.setIsSuccess(true);
        assertEquals(HttpStatus.CONTINUE, actualResponseBuilder.getHttpStatus());
        assertEquals(1, actualResponseBuilder.getHttpStatusCode().intValue());
        assertTrue(actualResponseBuilder.getIsSuccess());
    }


    @Test
    void testConstructor2() {
        ResponseBuilder<Object> actualResponseBuilder = new ResponseBuilder<>("Data", HttpStatus.CONTINUE, 1, true,
                mock(Timestamp.class));
        actualResponseBuilder.setData("Data");
        actualResponseBuilder.setDate(mock(Timestamp.class));
        actualResponseBuilder.setHttpStatus(HttpStatus.CONTINUE);
        actualResponseBuilder.setHttpStatusCode(1);
        actualResponseBuilder.setIsSuccess(true);
        assertEquals(HttpStatus.CONTINUE, actualResponseBuilder.getHttpStatus());
        assertEquals(1, actualResponseBuilder.getHttpStatusCode().intValue());
        assertTrue(actualResponseBuilder.getIsSuccess());
    }
}

