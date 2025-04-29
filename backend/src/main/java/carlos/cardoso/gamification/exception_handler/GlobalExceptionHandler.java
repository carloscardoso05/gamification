package carlos.cardoso.gamification.exception_handler;

import carlos.cardoso.gamification.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiException> handleException(Exception exception) {
        ApiException apiException = new ApiException(exception);
        return apiException.toResponse();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiException> handleResourceNotFoundException(ResourceNotFoundException exception) {
        return new ApiException(
                HttpStatus.NOT_FOUND,
                exception
        ).toResponse();
    }
}
