package demo.accountContext.shared;

public interface Entity<T> {
    boolean sameIdentityAs(T other);
}
