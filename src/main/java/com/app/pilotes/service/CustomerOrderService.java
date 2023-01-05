package com.app.pilotes.service;

import com.app.pilotes.model.response.ResponseBuilder;
import com.app.pilotes.model.dto.CustomerOrderResponse;
import com.app.pilotes.model.dto.CustomerOrdersRequest;

import java.util.List;
import java.util.Optional;

public interface CustomerOrderService {

    Optional<ResponseBuilder<CustomerOrderResponse>> addOrders(final List<CustomerOrdersRequest> orders);

    Optional<ResponseBuilder<CustomerOrderResponse>> updateOrders(CustomerOrdersRequest orders, String id);

    Optional<ResponseBuilder<CustomerOrderResponse>> searchOrders(String email, String search);
}
