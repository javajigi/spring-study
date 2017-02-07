package slipp.validate;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationExceptionController {
    private static final Logger log = LoggerFactory.getLogger(ValidationExceptionController.class);
    
    @Autowired
    private MessageSourceAccessor msa;
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationErrorsResponse handleValidationException(MethodArgumentNotValidException exception) {
        List<ObjectError> errors = exception.getBindingResult().getAllErrors();
        ValidationErrorsResponse response = new ValidationErrorsResponse();
        for (ObjectError objectError : errors) {
            FieldError fieldError = (FieldError)objectError;
            response.addValidationError(new ValidationError(fieldError.getField(), getErrorMessage(fieldError)));
        }
        return response;
    }

    private String getErrorMessage(FieldError fieldError) {
        String[] codes = fieldError.getCodes();
        String errorMessage = msa.getMessage(codes[0], fieldError.getArguments(), fieldError.getDefaultMessage());
        log.info("error message: {}", errorMessage);
        return errorMessage;
    }
}
