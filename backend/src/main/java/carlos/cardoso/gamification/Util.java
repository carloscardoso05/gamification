package carlos.cardoso.gamification;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public class Util {
    public static <T> Optional<T> findFirst(Collection<T> collection, T element) {
        return collection.stream().filter(e -> e.equals(element)).findFirst();
    }

    public static <T> Optional<T> findFirstWhere(Collection<T> collection, Predicate<T> predicate) {
        return collection.stream().filter(predicate).findFirst();
    }
}
