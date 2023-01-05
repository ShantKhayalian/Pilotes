package com.app.pilotes.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.app.pilotes.exceptions.ApplicationExceptions;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class AppPreconditionsTest {

    @Test
    void testCheckNotNullOrEmptyList() {
        assertThrows(ApplicationExceptions.class, () -> AppPreconditions.checkNotNullOrEmptyList(new ArrayList<>()));
    }

    @Test
    void testCheckNotNullOrEmptyList2() {
        ArrayList<Object> objectList = new ArrayList<>();
        objectList.add("42");
        assertEquals(1, AppPreconditions.checkNotNullOrEmptyList(objectList).size());
    }

    @Test
    void testCheckNotNullOrEmpty() {
        assertEquals("42", AppPreconditions.checkNotNullOrEmpty("42"));
        assertThrows(ApplicationExceptions.class, () -> AppPreconditions.checkNotNullOrEmpty(null));
    }
}

