package com.app.pilotes.model.dto;

import com.app.pilotes.annotations.ValidatePhoneInput;
import com.app.pilotes.annotations.ValidateEmailInput;
import com.app.pilotes.annotations.ValidatePilotsNumber;
import com.app.pilotes.annotations.ValidateStringInput;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOrdersRequest {
    @ApiModelProperty(name = "Customer firstName ", notes = "Customer firstName must not be less than 3 or larger than 255", example = "Shant", required = true,allowEmptyValue = false)
    @ValidateStringInput
    private String firstName;
    @ValidateStringInput
    @ApiModelProperty(name = "Customer lastName ", notes = "Customer lastName must not be less than 3 or larger than 255", example = "Khayalian", required = true,allowEmptyValue = false)
    private String lastName;
    @ValidatePhoneInput
    @ApiModelProperty(name = "Customer phone number ", notes = "Customer phone number must be valid phone number", example = "098229898", required = true,allowEmptyValue = false)
    private String telephoneNumber;
    @ValidateStringInput
    @ApiModelProperty(name = "Customer address ", notes = "Customer address must not be less than 3 or larger than 255", example = "Arkishti 7/4", required = true,allowEmptyValue = false)
    private String deliveryAddress;
    @ValidateEmailInput
    @ApiModelProperty(name = "Customer email ", notes = "Customer email must be valid email, containing all the email requirements.", example = "shantkh@gmail.com", required = true,allowEmptyValue = false)
    private String email;
    @ValidatePilotsNumber
    @ApiModelProperty(name = "Customer order of the pilotes per order ", notes = "Customer order limited between 5 and 15, can't order more or less the mentioned number, and also other numbers in between", example = "10", required = true,allowEmptyValue = false)
    private Integer numberOfPilots;

}
