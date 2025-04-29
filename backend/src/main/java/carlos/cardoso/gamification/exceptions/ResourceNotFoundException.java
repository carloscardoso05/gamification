package carlos.cardoso.gamification.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Class<?> clazz, Object id) {
        super("%s with id %s not found".formatted(clazz.getSimpleName(), id.toString()));
    }
}
