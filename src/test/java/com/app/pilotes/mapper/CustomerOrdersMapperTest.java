package com.app.pilotes.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.app.pilotes.model.Customer;
import com.app.pilotes.model.dto.CustomerOrderResponse;
import com.app.pilotes.model.dto.CustomerOrdersRequest;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class CustomerOrdersMapperTest {
    @Autowired
    private CustomerOrdersMapper customerOrdersMapper;

    @Test
    void testConvertFromOrderRequestListToOrderObjectList() {
        assertTrue(customerOrdersMapper.convertFromOrderRequestListToOrderObjectList(new ArrayList<>()).isEmpty());
    }

    @Test
    void testConvertFromOrderRequestListToOrderObjectList3() {
        CustomerOrdersRequest customerOrdersRequest = new CustomerOrdersRequest();
        customerOrdersRequest.setNumberOfPilots(10);

        ArrayList<CustomerOrdersRequest> customerOrdersRequestList = new ArrayList<>();
        customerOrdersRequestList.add(customerOrdersRequest);
        assertEquals(1,
                customerOrdersMapper.convertFromOrderRequestListToOrderObjectList(customerOrdersRequestList).size());
    }

    @Test
    void testConvertFromListOfCustomerObjectTOCustomerResponse() {
        assertTrue(customerOrdersMapper.convertFromListOfCustomerObjectTOCustomerResponse(new ArrayList<>()).isPresent());
    }

    @Test
    void testConvertFromListOfCustomerObjectTOCustomerResponse2() {
        Customer customer = new Customer();
        customer.setCreatedDate(mock(Timestamp.class));
        customer.setDeliveryAddress("42 Main St");
        customer.setEmail("jane.doe@example.org");
        customer.setFirstName("Jane");
        customer.setId(UUID.randomUUID());
        customer.setLastName("Doe");
        customer.setNumberOfPilots(10);
        customer.setTelephoneNumber("4105551212");
        customer.setTotal(BigDecimal.valueOf(42L));
        customer.setUpdatedDate(mock(Timestamp.class));

        ArrayList<Customer> customerList = new ArrayList<>();
        customerList.add(customer);
        assertTrue(customerOrdersMapper.convertFromListOfCustomerObjectTOCustomerResponse(customerList).isPresent());
    }

    @Test
    void testConvertFromListOfCustomerObjectTOCustomerResponse3() {
        Customer customer = new Customer();
        customer.setCreatedDate(mock(Timestamp.class));
        customer.setDeliveryAddress("42 Main St");
        customer.setEmail("jane.doe@example.org");
        customer.setFirstName("Jane");
        customer.setId(UUID.randomUUID());
        customer.setLastName("Doe");
        customer.setNumberOfPilots(10);
        customer.setTelephoneNumber("4105551212");
        customer.setTotal(BigDecimal.valueOf(42L));
        customer.setUpdatedDate(mock(Timestamp.class));

        Customer customer1 = new Customer();
        customer1.setCreatedDate(mock(Timestamp.class));
        customer1.setDeliveryAddress("42 Main St");
        customer1.setEmail("jane.doe@example.org");
        customer1.setFirstName("Jane");
        customer1.setId(UUID.randomUUID());
        customer1.setLastName("Doe");
        customer1.setNumberOfPilots(10);
        customer1.setTelephoneNumber("4105551212");
        customer1.setTotal(BigDecimal.valueOf(42L));
        customer1.setUpdatedDate(mock(Timestamp.class));

        ArrayList<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer);
        assertTrue(customerOrdersMapper.convertFromListOfCustomerObjectTOCustomerResponse(customerList).isPresent());
    }

    @Test
    void testConvertFromOrderRequestToOrderObject() {
        Customer actualConvertFromOrderRequestToOrderObjectResult = customerOrdersMapper
                .convertFromOrderRequestToOrderObject(new CustomerOrdersRequest());
        assertNull(actualConvertFromOrderRequestToOrderObjectResult.getTelephoneNumber());
        assertNull(actualConvertFromOrderRequestToOrderObjectResult.getNumberOfPilots());
        assertNull(actualConvertFromOrderRequestToOrderObjectResult.getLastName());
        assertNull(actualConvertFromOrderRequestToOrderObjectResult.getFirstName());
        assertNull(actualConvertFromOrderRequestToOrderObjectResult.getEmail());
        assertNull(actualConvertFromOrderRequestToOrderObjectResult.getDeliveryAddress());
    }


    @Test
    void testConvertFromOrderRequestToOrderObject2() {
        Customer actualConvertFromOrderRequestToOrderObjectResult = customerOrdersMapper
                .convertFromOrderRequestToOrderObject(
                        new CustomerOrdersRequest("Jane", "Doe", "4105551212", "42 Main St", "jane.doe@example.org", 10));
        assertEquals("4105551212", actualConvertFromOrderRequestToOrderObjectResult.getTelephoneNumber());
        assertEquals(10, actualConvertFromOrderRequestToOrderObjectResult.getNumberOfPilots().intValue());
        assertEquals("Doe", actualConvertFromOrderRequestToOrderObjectResult.getLastName());
        assertEquals("Jane", actualConvertFromOrderRequestToOrderObjectResult.getFirstName());
        assertEquals("jane.doe@example.org", actualConvertFromOrderRequestToOrderObjectResult.getEmail());
        assertEquals("42 Main St", actualConvertFromOrderRequestToOrderObjectResult.getDeliveryAddress());
    }

    @Test
    void testConvertFromOrderRequestToOrderObject4() {
        Customer actualConvertFromOrderRequestToOrderObjectResult = customerOrdersMapper
                .convertFromOrderRequestToOrderObject(
                        new CustomerOrdersRequest("42", "42", "4105551212", "42 Main St", "jane.doe@example.org", 10));
        assertEquals("4105551212", actualConvertFromOrderRequestToOrderObjectResult.getTelephoneNumber());
        assertEquals(10, actualConvertFromOrderRequestToOrderObjectResult.getNumberOfPilots().intValue());
        assertEquals("42", actualConvertFromOrderRequestToOrderObjectResult.getLastName());
        assertEquals("42", actualConvertFromOrderRequestToOrderObjectResult.getFirstName());
        assertEquals("jane.doe@example.org", actualConvertFromOrderRequestToOrderObjectResult.getEmail());
        assertEquals("42 Main St", actualConvertFromOrderRequestToOrderObjectResult.getDeliveryAddress());
    }

    @Test
    void testConvertFromObjectToResponse() {
        Customer customer = new Customer();
        customer.setCreatedDate(mock(Timestamp.class));
        customer.setDeliveryAddress("42 Main St");
        customer.setEmail("jane.doe@example.org");
        customer.setFirstName("Jane");
        UUID randomUUIDResult = UUID.randomUUID();
        customer.setId(randomUUIDResult);
        customer.setLastName("Doe");
        customer.setNumberOfPilots(10);
        customer.setTelephoneNumber("4105551212");
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        customer.setTotal(valueOfResult);
        customer.setUpdatedDate(mock(Timestamp.class));
        CustomerOrderResponse actualConvertFromObjectToResponseResult = customerOrdersMapper
                .convertFromObjectToResponse(customer);
        BigDecimal total = actualConvertFromObjectToResponseResult.getTotal();
        assertSame(valueOfResult, total);
        assertEquals("4105551212", actualConvertFromObjectToResponseResult.getTelephoneNumber());
        assertEquals("42 Main St", actualConvertFromObjectToResponseResult.getDeliveryAddress());
        assertEquals("Jane", actualConvertFromObjectToResponseResult.getFirstName());
        assertSame(randomUUIDResult, actualConvertFromObjectToResponseResult.getId());
        assertEquals(10, actualConvertFromObjectToResponseResult.getNumberOfPilots().intValue());
        assertEquals("jane.doe@example.org", actualConvertFromObjectToResponseResult.getEmail());
        assertEquals("Doe", actualConvertFromObjectToResponseResult.getLastName());
        assertEquals("42", total.toString());
    }

    @Test
    void testConvertFromObjectToResponse2() {
        UUID id = UUID.randomUUID();
        Timestamp createdDate = mock(Timestamp.class);
        Timestamp updatedDate = mock(Timestamp.class);
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);

        Customer customer = new Customer(id, createdDate, updatedDate, "Jane", "Doe", "jane.doe@example.org",
                "4105551212", "42 Main St", 10, valueOfResult);
        customer.setCreatedDate(mock(Timestamp.class));
        customer.setDeliveryAddress("42 Main St");
        customer.setEmail("jane.doe@example.org");
        customer.setFirstName("Jane");
        UUID randomUUIDResult = UUID.randomUUID();
        customer.setId(randomUUIDResult);
        customer.setLastName("Doe");
        customer.setNumberOfPilots(10);
        customer.setTelephoneNumber("4105551212");
        customer.setTotal(BigDecimal.valueOf(42L));
        customer.setUpdatedDate(mock(Timestamp.class));
        CustomerOrderResponse actualConvertFromObjectToResponseResult = customerOrdersMapper
                .convertFromObjectToResponse(customer);
        BigDecimal total = actualConvertFromObjectToResponseResult.getTotal();
        assertEquals(valueOfResult, total);
        assertEquals("4105551212", actualConvertFromObjectToResponseResult.getTelephoneNumber());
        assertEquals("42 Main St", actualConvertFromObjectToResponseResult.getDeliveryAddress());
        assertEquals("Jane", actualConvertFromObjectToResponseResult.getFirstName());
        assertSame(randomUUIDResult, actualConvertFromObjectToResponseResult.getId());
        assertEquals(10, actualConvertFromObjectToResponseResult.getNumberOfPilots().intValue());
        assertEquals("jane.doe@example.org", actualConvertFromObjectToResponseResult.getEmail());
        assertEquals("Doe", actualConvertFromObjectToResponseResult.getLastName());
        assertEquals("42", total.toString());
    }

    @Test
    void testConvertFromObjectToResponse3() {
        Customer customer = new Customer();
        customer.setCreatedDate(mock(Timestamp.class));
        customer.setDeliveryAddress("42 Main St");
        customer.setEmail("jane.doe@example.org");
        customer.setFirstName("Jane");
        customer.setId(null);
        customer.setLastName("Doe");
        customer.setNumberOfPilots(10);
        customer.setTelephoneNumber("4105551212");
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        customer.setTotal(valueOfResult);
        customer.setUpdatedDate(mock(Timestamp.class));
        CustomerOrderResponse actualConvertFromObjectToResponseResult = customerOrdersMapper
                .convertFromObjectToResponse(customer);
        BigDecimal total = actualConvertFromObjectToResponseResult.getTotal();
        assertSame(valueOfResult, total);
        assertEquals("4105551212", actualConvertFromObjectToResponseResult.getTelephoneNumber());
        assertEquals("42 Main St", actualConvertFromObjectToResponseResult.getDeliveryAddress());
        assertEquals("Jane", actualConvertFromObjectToResponseResult.getFirstName());
        assertNull(actualConvertFromObjectToResponseResult.getId());
        assertEquals(10, actualConvertFromObjectToResponseResult.getNumberOfPilots().intValue());
        assertEquals("Doe", actualConvertFromObjectToResponseResult.getLastName());
        assertEquals("jane.doe@example.org", actualConvertFromObjectToResponseResult.getEmail());
        assertEquals("42", total.toString());
    }
}

