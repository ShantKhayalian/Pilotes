package com.app.pilotes.model.response;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseBuilder<T>{
    private Object data;
    private HttpStatus httpStatus;
    private Integer httpStatusCode;
    private Boolean isSuccess;
    @CreationTimestamp
    private Timestamp date;
}