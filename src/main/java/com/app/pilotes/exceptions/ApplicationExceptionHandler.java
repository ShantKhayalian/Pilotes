package com.app.pilotes.exceptions;

import com.app.pilotes.model.response.ResponseBuilder;
import com.app.pilotes.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.impl.SizeLimitExceededException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@RequiredArgsConstructor
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ApplicationExceptionHandler<T> {


    @ExceptionHandler(value = {ApplicationExceptions.class, SizeLimitExceededException.class})
    ResponseEntity<ResponseBuilder<?>> ApplicationExceptions(ApplicationExceptions paginationInputExceptions){
        ResponseBuilder<?> result = new ResponseBuilder<>(
                paginationInputExceptions.getMessage(),
                HttpStatus.EXPECTATION_FAILED,
                HttpStatus.EXPECTATION_FAILED.value(),
                false,
                DateUtils.newTimeStamp()
        );
        return new ResponseEntity<ResponseBuilder<?>>(result,result.getHttpStatus());
    }

}
