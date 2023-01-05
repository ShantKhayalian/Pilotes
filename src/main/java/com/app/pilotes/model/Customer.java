package com.app.pilotes.model;

import com.app.pilotes.utils.PIIAttributeConverter;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "customer_id")
    private UUID id;

    @CreationTimestamp
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp updatedDate;
    @ApiModelProperty(name = "Customer firstName ", notes = "Customer FirstName must not be less than 3 or larger than 255", example = "Shant", required = true,allowEmptyValue = false)
    @Convert(converter = PIIAttributeConverter.class)
    private String firstName;
    @Convert(converter = PIIAttributeConverter.class)
    private String lastName;

    @Convert(converter = PIIAttributeConverter.class)
    private String email;

    @Convert(converter = PIIAttributeConverter.class)
    private String telephoneNumber;

    @Convert(converter = PIIAttributeConverter.class)
    private String deliveryAddress;

    private Integer numberOfPilots;

    private BigDecimal total;


}
