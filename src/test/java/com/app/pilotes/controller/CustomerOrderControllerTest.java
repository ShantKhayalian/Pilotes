package com.app.pilotes.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.app.pilotes.model.dto.CustomerOrderResponse;
import com.app.pilotes.model.dto.CustomerOrdersRequest;
import com.app.pilotes.model.response.ResponseBuilder;
import com.app.pilotes.service.impl.CustomerOrderServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CustomerOrderController.class})
@ExtendWith(SpringExtension.class)
class CustomerOrderControllerTest {
    @Autowired
    private CustomerOrderController customerOrderController;

    @MockBean
    private CustomerOrderServiceImpl customerOrderServiceImpl;


    @Test
    void testAddOrder2() {
        ResponseBuilder<CustomerOrderResponse> responseBuilder = new ResponseBuilder<>();
        responseBuilder.setHttpStatus(HttpStatus.CONTINUE);
        Optional<ResponseBuilder<CustomerOrderResponse>> ofResult = Optional.of(responseBuilder);
        when(customerOrderServiceImpl.addOrders((List<CustomerOrdersRequest>) any())).thenReturn(ofResult);
        ResponseEntity<ResponseBuilder<CustomerOrderResponse>> actualAddOrderResult = customerOrderController
                .addOrder(new ArrayList<>());
        assertTrue(actualAddOrderResult.hasBody());
        assertTrue(actualAddOrderResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.CONTINUE, actualAddOrderResult.getStatusCode());
        verify(customerOrderServiceImpl).addOrders((List<CustomerOrdersRequest>) any());
    }

    @Test
    void testAddOrder3() {
        ResponseBuilder<CustomerOrderResponse> responseBuilder = (ResponseBuilder<CustomerOrderResponse>) mock(
                ResponseBuilder.class);
        when(responseBuilder.getHttpStatus()).thenReturn(HttpStatus.CONTINUE);
        Optional<ResponseBuilder<CustomerOrderResponse>> ofResult = Optional.of(responseBuilder);
        when(customerOrderServiceImpl.addOrders((List<CustomerOrdersRequest>) any())).thenReturn(ofResult);
        ResponseEntity<ResponseBuilder<CustomerOrderResponse>> actualAddOrderResult = customerOrderController
                .addOrder(new ArrayList<>());
        assertTrue(actualAddOrderResult.hasBody());
        assertEquals(HttpStatus.CONTINUE, actualAddOrderResult.getStatusCode());
        assertTrue(actualAddOrderResult.getHeaders().isEmpty());
        verify(customerOrderServiceImpl).addOrders((List<CustomerOrdersRequest>) any());
        verify(responseBuilder).getHttpStatus();
    }

    @Test
    void testUpdateOrder2() {
        ResponseBuilder<CustomerOrderResponse> responseBuilder = new ResponseBuilder<>();
        responseBuilder.setHttpStatus(HttpStatus.CONTINUE);
        Optional<ResponseBuilder<CustomerOrderResponse>> ofResult = Optional.of(responseBuilder);
        when(customerOrderServiceImpl.updateOrders((CustomerOrdersRequest) any(), (String) any())).thenReturn(ofResult);
        ResponseEntity<ResponseBuilder<CustomerOrderResponse>> actualUpdateOrderResult = customerOrderController
                .updateOrder(new CustomerOrdersRequest(), "42");
        assertTrue(actualUpdateOrderResult.hasBody());
        assertTrue(actualUpdateOrderResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.CONTINUE, actualUpdateOrderResult.getStatusCode());
        verify(customerOrderServiceImpl).updateOrders((CustomerOrdersRequest) any(), (String) any());
    }


    @Test
    void testUpdateOrder3() {
        ResponseBuilder<CustomerOrderResponse> responseBuilder = (ResponseBuilder<CustomerOrderResponse>) mock(
                ResponseBuilder.class);
        when(responseBuilder.getHttpStatus()).thenReturn(HttpStatus.CONTINUE);
        Optional<ResponseBuilder<CustomerOrderResponse>> ofResult = Optional.of(responseBuilder);
        when(customerOrderServiceImpl.updateOrders((CustomerOrdersRequest) any(), (String) any())).thenReturn(ofResult);
        ResponseEntity<ResponseBuilder<CustomerOrderResponse>> actualUpdateOrderResult = customerOrderController
                .updateOrder(new CustomerOrdersRequest(), "42");
        assertTrue(actualUpdateOrderResult.hasBody());
        assertEquals(HttpStatus.CONTINUE, actualUpdateOrderResult.getStatusCode());
        assertTrue(actualUpdateOrderResult.getHeaders().isEmpty());
        verify(customerOrderServiceImpl).updateOrders((CustomerOrdersRequest) any(), (String) any());
        verify(responseBuilder).getHttpStatus();
    }

    @Test
    void testSearchOrder2() {
        ResponseBuilder<CustomerOrderResponse> responseBuilder = new ResponseBuilder<>();
        responseBuilder.setHttpStatus(HttpStatus.CONTINUE);
        Optional<ResponseBuilder<CustomerOrderResponse>> ofResult = Optional.of(responseBuilder);
        when(customerOrderServiceImpl.searchOrders((String) any(), (String) any())).thenReturn(ofResult);
        ResponseEntity<ResponseBuilder<CustomerOrderResponse>> actualSearchOrderResult = customerOrderController
                .searchOrder("jane.doe@example.org", "Query");
        assertTrue(actualSearchOrderResult.hasBody());
        assertTrue(actualSearchOrderResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.CONTINUE, actualSearchOrderResult.getStatusCode());
        verify(customerOrderServiceImpl).searchOrders((String) any(), (String) any());
    }


    @Test
    void testSearchOrder3() {
        ResponseBuilder<CustomerOrderResponse> responseBuilder = (ResponseBuilder<CustomerOrderResponse>) mock(
                ResponseBuilder.class);
        when(responseBuilder.getHttpStatus()).thenReturn(HttpStatus.CONTINUE);
        Optional<ResponseBuilder<CustomerOrderResponse>> ofResult = Optional.of(responseBuilder);
        when(customerOrderServiceImpl.searchOrders((String) any(), (String) any())).thenReturn(ofResult);
        ResponseEntity<ResponseBuilder<CustomerOrderResponse>> actualSearchOrderResult = customerOrderController
                .searchOrder("jane.doe@example.org", "Query");
        assertTrue(actualSearchOrderResult.hasBody());
        assertEquals(HttpStatus.CONTINUE, actualSearchOrderResult.getStatusCode());
        assertTrue(actualSearchOrderResult.getHeaders().isEmpty());
        verify(customerOrderServiceImpl).searchOrders((String) any(), (String) any());
        verify(responseBuilder).getHttpStatus();
    }


}

