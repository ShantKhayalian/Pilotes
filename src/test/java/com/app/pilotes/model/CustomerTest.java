package com.app.pilotes.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    void testConstructor() {
        Customer actualCustomer = new Customer();
        actualCustomer.setCreatedDate(mock(Timestamp.class));
        actualCustomer.setDeliveryAddress("42 Main St");
        actualCustomer.setEmail("jane.doe@example.org");
        actualCustomer.setFirstName("Jane");
        UUID randomUUIDResult = UUID.randomUUID();
        actualCustomer.setId(randomUUIDResult);
        actualCustomer.setLastName("Doe");
        actualCustomer.setNumberOfPilots(10);
        actualCustomer.setTelephoneNumber("4105551212");
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        actualCustomer.setTotal(valueOfResult);
        actualCustomer.setUpdatedDate(mock(Timestamp.class));
        actualCustomer.toString();
        assertEquals("42 Main St", actualCustomer.getDeliveryAddress());
        assertEquals("jane.doe@example.org", actualCustomer.getEmail());
        assertEquals("Jane", actualCustomer.getFirstName());
        assertSame(randomUUIDResult, actualCustomer.getId());
        assertEquals("Doe", actualCustomer.getLastName());
        assertEquals(10, actualCustomer.getNumberOfPilots().intValue());
        assertEquals("4105551212", actualCustomer.getTelephoneNumber());
        assertSame(valueOfResult, actualCustomer.getTotal());
    }


    @Test
    void testConstructor2() {
        UUID id = UUID.randomUUID();
        Timestamp createdDate = mock(Timestamp.class);
        Timestamp updatedDate = mock(Timestamp.class);
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        Customer actualCustomer = new Customer(id, createdDate, updatedDate, "Jane", "Doe", "jane.doe@example.org",
                "4105551212", "42 Main St", 10, valueOfResult);
        actualCustomer.setCreatedDate(mock(Timestamp.class));
        actualCustomer.setDeliveryAddress("42 Main St");
        actualCustomer.setEmail("jane.doe@example.org");
        actualCustomer.setFirstName("Jane");
        UUID randomUUIDResult = UUID.randomUUID();
        actualCustomer.setId(randomUUIDResult);
        actualCustomer.setLastName("Doe");
        actualCustomer.setNumberOfPilots(10);
        actualCustomer.setTelephoneNumber("4105551212");
        BigDecimal valueOfResult1 = BigDecimal.valueOf(42L);
        actualCustomer.setTotal(valueOfResult1);
        actualCustomer.setUpdatedDate(mock(Timestamp.class));
        actualCustomer.toString();
        assertEquals("42 Main St", actualCustomer.getDeliveryAddress());
        assertEquals("jane.doe@example.org", actualCustomer.getEmail());
        assertEquals("Jane", actualCustomer.getFirstName());
        assertSame(randomUUIDResult, actualCustomer.getId());
        assertEquals("Doe", actualCustomer.getLastName());
        assertEquals(10, actualCustomer.getNumberOfPilots().intValue());
        assertEquals("4105551212", actualCustomer.getTelephoneNumber());
        BigDecimal total = actualCustomer.getTotal();
        assertSame(valueOfResult1, total);
        assertEquals(valueOfResult, total);
    }
}

