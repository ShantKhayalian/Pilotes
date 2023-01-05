package com.app.pilotes.model.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CustomerOrdersRequestTest {

    @Test
    void testConstructor() {
        CustomerOrdersRequest actualCustomerOrdersRequest = new CustomerOrdersRequest();
        actualCustomerOrdersRequest.setDeliveryAddress("42 Main St");
        actualCustomerOrdersRequest.setEmail("jane.doe@example.org");
        actualCustomerOrdersRequest.setFirstName("Jane");
        actualCustomerOrdersRequest.setLastName("Doe");
        actualCustomerOrdersRequest.setNumberOfPilots(10);
        actualCustomerOrdersRequest.setTelephoneNumber("4105551212");
        assertEquals("42 Main St", actualCustomerOrdersRequest.getDeliveryAddress());
        assertEquals("jane.doe@example.org", actualCustomerOrdersRequest.getEmail());
        assertEquals("Jane", actualCustomerOrdersRequest.getFirstName());
        assertEquals("Doe", actualCustomerOrdersRequest.getLastName());
        assertEquals(10, actualCustomerOrdersRequest.getNumberOfPilots().intValue());
        assertEquals("4105551212", actualCustomerOrdersRequest.getTelephoneNumber());
    }

    @Test
    void testConstructor2() {
        CustomerOrdersRequest actualCustomerOrdersRequest = new CustomerOrdersRequest("Jane", "Doe", "4105551212",
                "42 Main St", "jane.doe@example.org", 10);
        actualCustomerOrdersRequest.setDeliveryAddress("42 Main St");
        actualCustomerOrdersRequest.setEmail("jane.doe@example.org");
        actualCustomerOrdersRequest.setFirstName("Jane");
        actualCustomerOrdersRequest.setLastName("Doe");
        actualCustomerOrdersRequest.setNumberOfPilots(10);
        actualCustomerOrdersRequest.setTelephoneNumber("4105551212");
        assertEquals("42 Main St", actualCustomerOrdersRequest.getDeliveryAddress());
        assertEquals("jane.doe@example.org", actualCustomerOrdersRequest.getEmail());
        assertEquals("Jane", actualCustomerOrdersRequest.getFirstName());
        assertEquals("Doe", actualCustomerOrdersRequest.getLastName());
        assertEquals(10, actualCustomerOrdersRequest.getNumberOfPilots().intValue());
        assertEquals("4105551212", actualCustomerOrdersRequest.getTelephoneNumber());
    }
}

