package samuelfsd.com.br.myexpenses.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import samuelfsd.com.br.myexpenses.common.ConvertData;
import samuelfsd.com.br.myexpenses.domain.exception.ResourceBadRequestException;
import samuelfsd.com.br.myexpenses.domain.exception.ResourceNotFoundException;
import samuelfsd.com.br.myexpenses.domain.model.ResponseError;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseError> handlerResourceNotFoundException(ResourceNotFoundException ex) {

        String data = ConvertData.convertDateTime(new Date());
        ResponseError error = new ResponseError(data, HttpStatus.NOT_FOUND.value(), "Not found", ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceBadRequestException.class)
    public ResponseEntity<ResponseError> handlerResourceBadRequestException(ResourceBadRequestException ex){

        String data =  ConvertData.convertDateTime(new Date());
        ResponseError error = new ResponseError(data, HttpStatus.BAD_REQUEST.value(), "Bad request", ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> handlerResourceException(Exception ex) {
        String data =  ConvertData.convertDateTime(new Date());

        ResponseError error = new ResponseError(data, HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error", ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
