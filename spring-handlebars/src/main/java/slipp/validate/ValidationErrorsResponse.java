package slipp.validate;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorsResponse {
    private boolean status = false;
    
    private List<ValidationError> errors;
    
    public ValidationErrorsResponse() {
        errors = new ArrayList<>();
    }
    
    public void addValidationError(ValidationError error) {
        errors.add(error);
    }
    
    public boolean isStatus() {
        return status;
    }
    
    public List<ValidationError> getErrors() {
        return errors;
    }
}
