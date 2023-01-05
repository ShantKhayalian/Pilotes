package com.app.pilotes.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.app.pilotes.model.Customer;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {CustomerOrdersRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.app.pilotes.model"})
@DataJpaTest
class CustomerOrdersRepositoryTest {
    @Autowired
    private CustomerOrdersRepository customerOrdersRepository;

    @Test
    void testFindByIdAndCreatedDatePassed5Minutes() {
        Timestamp timestamp = mock(Timestamp.class);
        when(timestamp.getNanos()).thenReturn(1);
        when(timestamp.getTime()).thenReturn(10L);
        Timestamp timestamp1 = mock(Timestamp.class);
        when(timestamp1.getNanos()).thenReturn(1);
        when(timestamp1.getTime()).thenReturn(10L);

        Customer customer = new Customer();
        customer.setCreatedDate(timestamp);
        customer.setDeliveryAddress("42 Main St");
        customer.setEmail("jane.doe@example.org");
        customer.setFirstName("Jane");
        customer.setLastName("Doe");
        customer.setNumberOfPilots(10);
        customer.setTelephoneNumber("4105551212");
        customer.setTotal(BigDecimal.valueOf(42L));
        customer.setUpdatedDate(timestamp1);
        Timestamp timestamp2 = mock(Timestamp.class);
        when(timestamp2.getNanos()).thenReturn(1);
        when(timestamp2.getTime()).thenReturn(10L);
        Timestamp timestamp3 = mock(Timestamp.class);
        when(timestamp3.getNanos()).thenReturn(1);
        when(timestamp3.getTime()).thenReturn(10L);

        Customer customer1 = new Customer();
        customer1.setCreatedDate(timestamp2);
        customer1.setDeliveryAddress("42 Main St");
        customer1.setEmail("jane.doe@example.org");
        customer1.setFirstName("Jane");
        customer1.setLastName("Doe");
        customer1.setNumberOfPilots(10);
        customer1.setTelephoneNumber("4105551212");
        customer1.setTotal(BigDecimal.valueOf(42L));
        customer1.setUpdatedDate(timestamp3);
        customerOrdersRepository.save(customer);
        customerOrdersRepository.save(customer1);
        UUID randomUUIDResult = UUID.randomUUID();
        Timestamp timestamp4 = mock(Timestamp.class);
        when(timestamp4.getNanos()).thenReturn(1);
        when(timestamp4.getTime()).thenReturn(10L);
        assertFalse(
                customerOrdersRepository.findByIdAndCreatedDatePassed5Minutes(randomUUIDResult, timestamp4).isPresent());
        verify(timestamp, atLeast(1)).getNanos();
        verify(timestamp, atLeast(1)).getTime();
        verify(timestamp1, atLeast(1)).getNanos();
        verify(timestamp1, atLeast(1)).getTime();
        verify(timestamp2, atLeast(1)).getNanos();
        verify(timestamp2, atLeast(1)).getTime();
        verify(timestamp3, atLeast(1)).getNanos();
        verify(timestamp3, atLeast(1)).getTime();
        verify(timestamp4).getNanos();
        verify(timestamp4).getTime();
    }


    @Test
    void testFindAllByEmail() {
        Timestamp timestamp = mock(Timestamp.class);
        when(timestamp.getNanos()).thenReturn(1);
        when(timestamp.getTime()).thenReturn(10L);
        Timestamp timestamp1 = mock(Timestamp.class);
        when(timestamp1.getNanos()).thenReturn(1);
        when(timestamp1.getTime()).thenReturn(10L);

        Customer customer = new Customer();
        customer.setCreatedDate(timestamp);
        customer.setDeliveryAddress("42 Main St");
        customer.setEmail("jane.doe@example.org");
        customer.setFirstName("Jane");
        customer.setLastName("Doe");
        customer.setNumberOfPilots(10);
        customer.setTelephoneNumber("4105551212");
        customer.setTotal(BigDecimal.valueOf(42L));
        customer.setUpdatedDate(timestamp1);
        Timestamp timestamp2 = mock(Timestamp.class);
        when(timestamp2.getNanos()).thenReturn(1);
        when(timestamp2.getTime()).thenReturn(10L);
        Timestamp timestamp3 = mock(Timestamp.class);
        when(timestamp3.getNanos()).thenReturn(1);
        when(timestamp3.getTime()).thenReturn(10L);

        Customer customer1 = new Customer();
        customer1.setCreatedDate(timestamp2);
        customer1.setDeliveryAddress("42 Main St");
        customer1.setEmail("jane.doe@example.org");
        customer1.setFirstName("Jane");
        customer1.setLastName("Doe");
        customer1.setNumberOfPilots(10);
        customer1.setTelephoneNumber("4105551212");
        customer1.setTotal(BigDecimal.valueOf(42L));
        customer1.setUpdatedDate(timestamp3);
        customerOrdersRepository.save(customer);
        customerOrdersRepository.save(customer1);
        assertTrue(customerOrdersRepository.findAllByEmail("foo").isEmpty());
        verify(timestamp, atLeast(1)).getNanos();
        verify(timestamp, atLeast(1)).getTime();
        verify(timestamp1, atLeast(1)).getNanos();
        verify(timestamp1, atLeast(1)).getTime();
        verify(timestamp2, atLeast(1)).getNanos();
        verify(timestamp2, atLeast(1)).getTime();
        verify(timestamp3, atLeast(1)).getNanos();
        verify(timestamp3, atLeast(1)).getTime();
    }
}

