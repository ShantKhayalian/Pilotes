package com.app.pilotes.api;

import com.app.pilotes.enums.Urls;
import com.app.pilotes.model.response.ResponseBuilder;
import com.app.pilotes.model.dto.CustomerOrderResponse;
import com.app.pilotes.model.dto.CustomerOrdersRequest;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success|OK"),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Not Authorized!"),
        @ApiResponse(code = 403, message = "Forbidden!"),
        @ApiResponse(code = 404, message = "Not Found!"),
        @ApiResponse(code = 417, message = "Custom Error messages"),
        @ApiResponse(code = 500, message = "Internal server error")})
@ApiOperation("Customer order API")
public interface CustomerOrderApi {

    @RequestMapping(value = Urls.ORDERS,
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Add order API", notes = "Returns the new order with details.")

    ResponseEntity<ResponseBuilder<CustomerOrderResponse>> addOrder(@RequestBody @Valid final List<CustomerOrdersRequest> orders);

    @RequestMapping(value = Urls.UPDATE_ORDERS,
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update order API", notes = "Returns the updated order, in case it's not passed the five minutes.")
    ResponseEntity<ResponseBuilder<CustomerOrderResponse>> updateOrder(@RequestBody @Valid final CustomerOrdersRequest orders,
                                                                       @PathVariable @Valid final String id);

    @RequestMapping(value = Urls.SEARCH_ORDERS,
            method = RequestMethod.POST)
    @ApiOperation(value = "Search order API", notes = "Returns all the orders, if user already had any.")
    ResponseEntity<ResponseBuilder<CustomerOrderResponse>> searchOrder(@PathVariable @Valid final String email,
                                                                       @PathVariable @Valid final String query);

}
