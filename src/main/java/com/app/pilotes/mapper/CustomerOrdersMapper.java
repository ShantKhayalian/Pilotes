package com.app.pilotes.mapper;

import com.app.pilotes.model.Customer;
import com.app.pilotes.model.dto.CustomerOrderResponse;
import com.app.pilotes.model.dto.CustomerOrdersRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.app.pilotes.enums.ProductPrice.PRICE;

@Component
public class CustomerOrdersMapper {

    private ModelMapper modelMapper;

    public CustomerOrdersMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<Customer> convertFromOrderRequestListToOrderObjectList(List<CustomerOrdersRequest> orders) {
        return orders
                .stream()
                .map(e -> Customer.builder()
                        .firstName(e.getFirstName())
                        .lastName(e.getLastName())
                        .telephoneNumber(e.getTelephoneNumber())
                        .email(e.getEmail())
                        .deliveryAddress(e.getDeliveryAddress())
                        .numberOfPilots(e.getNumberOfPilots())
                        .total(PRICE.multiply(new BigDecimal(e.getNumberOfPilots())))
                        .build())
                .collect(Collectors.toList());
    }

    public Optional<List<CustomerOrderResponse>> convertFromListOfCustomerObjectTOCustomerResponse(List<Customer> customer) {
        return Optional.of(customer
                .stream()
                .map(e -> CustomerOrderResponse.builder()
                        .id(e.getId())
                        .firstName(e.getFirstName())
                        .lastName(e.getLastName())
                        .createdDate(e.getCreatedDate())
                        .updatedDate(e.getUpdatedDate())
                        .telephoneNumber(e.getTelephoneNumber())
                        .deliveryAddress(e.getDeliveryAddress())
                        .email(e.getEmail())
                        .numberOfPilots(e.getNumberOfPilots())
                        .total(e.getTotal())
                        .build())
                .collect(Collectors.toList()));
    }

    public Customer convertFromOrderRequestToOrderObject(CustomerOrdersRequest customerOrders) {
        return modelMapper.map(customerOrders, Customer.class);
    }

    public CustomerOrderResponse convertFromObjectToResponse(Customer customer) {
        return modelMapper.map(customer, CustomerOrderResponse.class);
    }
}
