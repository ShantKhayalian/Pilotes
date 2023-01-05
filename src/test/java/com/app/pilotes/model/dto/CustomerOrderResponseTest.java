package com.app.pilotes.model.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

import org.junit.jupiter.api.Test;

class CustomerOrderResponseTest {

    @Test
    void testConstructor() {
        CustomerOrderResponse actualCustomerOrderResponse = new CustomerOrderResponse();
        actualCustomerOrderResponse.setCreatedDate(mock(Timestamp.class));
        actualCustomerOrderResponse.setDeliveryAddress("42 Main St");
        actualCustomerOrderResponse.setEmail("jane.doe@example.org");
        actualCustomerOrderResponse.setFirstName("Jane");
        UUID randomUUIDResult = UUID.randomUUID();
        actualCustomerOrderResponse.setId(randomUUIDResult);
        actualCustomerOrderResponse.setLastName("Doe");
        actualCustomerOrderResponse.setNumberOfPilots(10);
        actualCustomerOrderResponse.setTelephoneNumber("4105551212");
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        actualCustomerOrderResponse.setTotal(valueOfResult);
        actualCustomerOrderResponse.setUpdatedDate(mock(Timestamp.class));
        assertEquals("42 Main St", actualCustomerOrderResponse.getDeliveryAddress());
        assertEquals("jane.doe@example.org", actualCustomerOrderResponse.getEmail());
        assertEquals("Jane", actualCustomerOrderResponse.getFirstName());
        assertSame(randomUUIDResult, actualCustomerOrderResponse.getId());
        assertEquals("Doe", actualCustomerOrderResponse.getLastName());
        assertEquals(10, actualCustomerOrderResponse.getNumberOfPilots().intValue());
        assertEquals("4105551212", actualCustomerOrderResponse.getTelephoneNumber());
        assertSame(valueOfResult, actualCustomerOrderResponse.getTotal());
    }


    @Test
    void testConstructor2() {
        UUID id = UUID.randomUUID();
        Timestamp createdDate = mock(Timestamp.class);
        Timestamp updatedDate = mock(Timestamp.class);
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        CustomerOrderResponse actualCustomerOrderResponse = new CustomerOrderResponse(id, createdDate, updatedDate,
                "Jane", "Doe", "4105551212", "42 Main St", "jane.doe@example.org", 10, valueOfResult);
        actualCustomerOrderResponse.setCreatedDate(mock(Timestamp.class));
        actualCustomerOrderResponse.setDeliveryAddress("42 Main St");
        actualCustomerOrderResponse.setEmail("jane.doe@example.org");
        actualCustomerOrderResponse.setFirstName("Jane");
        UUID randomUUIDResult = UUID.randomUUID();
        actualCustomerOrderResponse.setId(randomUUIDResult);
        actualCustomerOrderResponse.setLastName("Doe");
        actualCustomerOrderResponse.setNumberOfPilots(10);
        actualCustomerOrderResponse.setTelephoneNumber("4105551212");
        BigDecimal valueOfResult1 = BigDecimal.valueOf(42L);
        actualCustomerOrderResponse.setTotal(valueOfResult1);
        actualCustomerOrderResponse.setUpdatedDate(mock(Timestamp.class));
        assertEquals("42 Main St", actualCustomerOrderResponse.getDeliveryAddress());
        assertEquals("jane.doe@example.org", actualCustomerOrderResponse.getEmail());
        assertEquals("Jane", actualCustomerOrderResponse.getFirstName());
        assertSame(randomUUIDResult, actualCustomerOrderResponse.getId());
        assertEquals("Doe", actualCustomerOrderResponse.getLastName());
        assertEquals(10, actualCustomerOrderResponse.getNumberOfPilots().intValue());
        assertEquals("4105551212", actualCustomerOrderResponse.getTelephoneNumber());
        BigDecimal total = actualCustomerOrderResponse.getTotal();
        assertSame(valueOfResult1, total);
        assertEquals(valueOfResult, total);
    }
}

