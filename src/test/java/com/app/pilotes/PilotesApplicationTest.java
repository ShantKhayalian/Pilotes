package com.app.pilotes;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PilotesApplicationTest {

    @Test
    public void testEmailValidator() {
        assertTrue((new PilotesApplication()).emailValidator().isValid("jane.doe@example.org", null));
    }

}

