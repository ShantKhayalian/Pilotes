package com.app.pilotes.controller;

import com.app.pilotes.api.CustomerOrderApi;
import com.app.pilotes.model.dto.CustomerOrderResponse;
import com.app.pilotes.model.dto.CustomerOrdersRequest;
import com.app.pilotes.model.response.ResponseBuilder;
import com.app.pilotes.service.impl.CustomerOrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Validated
public class CustomerOrderController implements CustomerOrderApi {
    private final CustomerOrderServiceImpl orderService;

    @Override
    public ResponseEntity<ResponseBuilder<CustomerOrderResponse>> addOrder(List<CustomerOrdersRequest> orders) {
        Optional<ResponseBuilder<CustomerOrderResponse>> result = orderService.addOrders(orders);
        return new ResponseEntity<>(result.get(), result.get().getHttpStatus());
    }

    @Override
    public ResponseEntity<ResponseBuilder<CustomerOrderResponse>> updateOrder(CustomerOrdersRequest orders, String id) {
        Optional<ResponseBuilder<CustomerOrderResponse>> result = orderService.updateOrders(orders, id);
        return new ResponseEntity<>(result.get(), result.get().getHttpStatus());
    }

    @Override
    public ResponseEntity<ResponseBuilder<CustomerOrderResponse>> searchOrder(String email, String query) {
        Optional<ResponseBuilder<CustomerOrderResponse>> result = orderService.searchOrders(email, query);
        return new ResponseEntity<>(result.get(), result.get().getHttpStatus());
    }
}
