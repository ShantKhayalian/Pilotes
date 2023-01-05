package com.app.pilotes.model.dto;

import lombok.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerOrderResponse {
    private UUID id;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String deliveryAddress;
    private String email;
    private Integer numberOfPilots;
    private BigDecimal total;
}
