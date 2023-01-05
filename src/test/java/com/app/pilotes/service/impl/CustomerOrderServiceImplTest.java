package com.app.pilotes.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.app.pilotes.exceptions.ApplicationExceptions;
import com.app.pilotes.mapper.CustomerOrdersMapper;
import com.app.pilotes.model.Customer;
import com.app.pilotes.model.dto.CustomerOrderResponse;
import com.app.pilotes.model.dto.CustomerOrdersRequest;
import com.app.pilotes.repository.CustomerOrdersRepository;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ExtendWith(SpringExtension.class)
class CustomerOrderServiceImplTest {
    @Autowired
    private CustomerOrderServiceImpl customerOrderServiceImpl;

    @MockBean
    private CustomerOrdersMapper customerOrdersMapper;

    @MockBean
    private CustomerOrdersRepository customerOrdersRepository;


    @Test
    void testAddOrders() {
        when(customerOrdersMapper.convertFromOrderRequestListToOrderObjectList((List<CustomerOrdersRequest>) any()))
                .thenReturn(new ArrayList<>());
        when(customerOrdersMapper.convertFromListOfCustomerObjectTOCustomerResponse(any()))
                .thenReturn(Optional.of(new ArrayList<>()));
        when(customerOrdersRepository.saveAllAndFlush(any()))
                .thenThrow(new ApplicationExceptions("An error occurred"));

        ArrayList<CustomerOrdersRequest> customerOrdersRequestList = new ArrayList<>();
        customerOrdersRequestList.add(new CustomerOrdersRequest());
        assertThrows(ApplicationExceptions.class, () -> customerOrderServiceImpl.addOrders(customerOrdersRequestList));
        verify(customerOrdersMapper).convertFromOrderRequestListToOrderObjectList(any());
        verify(customerOrdersRepository).saveAllAndFlush(any());
    }

    @Test
    void testUpdateOrders() {
        assertThrows(ApplicationExceptions.class,
                () -> customerOrderServiceImpl.updateOrders(new CustomerOrdersRequest(), UUID.randomUUID().toString()));
    }



    @Test
    void testSearchOrders() {
        assertThrows(ApplicationExceptions.class,
                () -> customerOrderServiceImpl.searchOrders("l.UlUlUlUlUl.U", "Search"));
    }
}

