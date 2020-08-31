package demo.accountContext.shared;

public interface ValueObject<T> {
    boolean sameValueAs(T other);
}
