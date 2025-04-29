package carlos.cardoso.gamification.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public record ApiException(
        HttpStatusCode code,
        String message
) {
    public ApiException(Exception exception) {
        this(HttpStatus.INTERNAL_SERVER_ERROR, exception);
    }

    public ApiException(HttpStatusCode code, Exception exception) {
        this(code, exception.getMessage());
    }

    public ResponseEntity<ApiException> toResponse() {
        return ResponseEntity.status(code.value()).body(new ApiException(code, message));
    }
}
