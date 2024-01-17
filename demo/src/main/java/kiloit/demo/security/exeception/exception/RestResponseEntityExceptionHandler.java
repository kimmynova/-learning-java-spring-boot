package kiloit.demo.security.exeception.exception;

import kiloit.demo.base.StructureRS;
import kiloit.demo.config.constants.MessageConstant;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadResqestException.class)
    public ResponseEntity<StructureRS>badRequestException(BadResqestException ex){
        StructureRS structureRS = new StructureRS(
                HttpStatus.BAD_REQUEST,
                ex.getMessage()
        );

        return new ResponseEntity<>(structureRS,HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> errors = new ArrayList<String>();
        for (FieldError error: ex.getBindingResult().getFieldErrors()){
            errors.add(error.getField()+ ":" + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()){
            errors.add(error.getObjectName()+":"+error.getDefaultMessage());
        }
                StructureRS structureRS =new StructureRS(
                        HttpStatus.BAD_REQUEST,
                        MessageConstant.VALIDATION_FAILEDS,errors
                );
                        return new ResponseEntity<>(structureRS,HttpStatus.BAD_REQUEST);
    }
}
