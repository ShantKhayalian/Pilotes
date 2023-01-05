package com.app.pilotes.service.impl;

import com.app.pilotes.exceptions.ApplicationExceptions;
import com.app.pilotes.mapper.CustomerOrdersMapper;
import com.app.pilotes.model.Customer;
import com.app.pilotes.model.response.ResponseBuilder;
import com.app.pilotes.model.dto.CustomerOrderResponse;
import com.app.pilotes.model.dto.CustomerOrdersRequest;
import com.app.pilotes.repository.CustomerOrdersRepository;
import com.app.pilotes.service.CustomerOrderService;
import com.app.pilotes.utils.AppPreconditions;
import com.app.pilotes.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

import static com.app.pilotes.enums.MessagesConsts.DONT_HAVE_PERMISSION;
import static com.app.pilotes.enums.MessagesConsts.ORDER_ERROR;
import static com.app.pilotes.enums.ProductPrice.PRICE;
import static com.app.pilotes.utils.DateUtils.fiveMinutesTime;

@Service
@RequiredArgsConstructor
public class CustomerOrderServiceImpl implements CustomerOrderService {

    private final CustomerOrdersMapper orderMapper;
    private final CustomerOrdersRepository customerOrdersRepository;

    @Override
    public Optional<ResponseBuilder<CustomerOrderResponse>> addOrders(List<CustomerOrdersRequest> customerOrders) {
        AppPreconditions.checkNotNullOrEmptyList(customerOrders);
        AppPreconditions.checkNotNullOrEmpty(customerOrders);
        List<Customer> order = orderMapper.convertFromOrderRequestListToOrderObjectList(customerOrders);
        List<Customer> customer = customerOrdersRepository.saveAllAndFlush(order);
        Optional<List<CustomerOrderResponse>> result = orderMapper.convertFromListOfCustomerObjectTOCustomerResponse(customer);
        return Optional.of(result.map(e -> ResponseBuilder.<CustomerOrderResponse>builder()
                        .data(result)
                        .httpStatusCode(HttpStatus.CREATED.value())
                        .httpStatus(HttpStatus.CREATED)
                        .isSuccess(true)
                        .date(DateUtils.newTimeStamp())
                        .build())
                .orElseThrow());
    }

    @Override
    public Optional<ResponseBuilder<CustomerOrderResponse>> updateOrders(CustomerOrdersRequest customerOrders, String id) {
        AppPreconditions.checkNotNullOrEmpty(customerOrders);
        AppPreconditions.checkNotNullOrEmpty(id);
        Timestamp fiveMinutesInterval = fiveMinutesTime();
        Optional<Customer> orderData = customerOrdersRepository.findByIdAndCreatedDatePassed5Minutes(UUID.fromString(id), fiveMinutesInterval);
        if (orderData.isEmpty()) throw new ApplicationExceptions(ORDER_ERROR);
        Customer order = orderMapper.convertFromOrderRequestToOrderObject(customerOrders);
        order.setTotal(PRICE.multiply(new BigDecimal(order.getNumberOfPilots())));
        order.setUpdatedDate(DateUtils.newTimeStamp());
        Customer customer = customerOrdersRepository.save(order);
        CustomerOrderResponse result = orderMapper.convertFromObjectToResponse(customer);
        return Optional.of(Optional.of(ResponseBuilder.<CustomerOrderResponse>builder()
                        .data(result)
                        .httpStatusCode(HttpStatus.OK.value())
                        .httpStatus(HttpStatus.OK)
                        .isSuccess(true)
                        .date(DateUtils.newTimeStamp())
                        .build())
                .orElseThrow());

    }

    @Override
    public Optional<ResponseBuilder<CustomerOrderResponse>> searchOrders(String email, String search) {
        AppPreconditions.checkNotNullOrEmpty(email);
        AppPreconditions.checkNotNullOrEmpty(search);
        List<Customer> orderData = customerOrdersRepository.findAllByEmail(email);
        if(orderData.size() == 0) throw new ApplicationExceptions(DONT_HAVE_PERMISSION);
        String searchTerm = search.trim().toLowerCase();
        List<Customer> orders = orderData.stream()
                .filter(e -> e.getFirstName().trim().toLowerCase().contains(searchTerm) || e.getLastName().trim().toLowerCase().contains(searchTerm))
                .collect(Collectors.toList());
        Optional<List<CustomerOrderResponse>> result = orderMapper.convertFromListOfCustomerObjectTOCustomerResponse(orders);
        return Optional.of(Optional.of(ResponseBuilder.<CustomerOrderResponse>builder()
                        .data(result)
                        .httpStatusCode(HttpStatus.OK.value())
                        .httpStatus(HttpStatus.OK)
                        .isSuccess(true)
                        .date(DateUtils.newTimeStamp())
                        .build())
                .orElseThrow());
    }
}
