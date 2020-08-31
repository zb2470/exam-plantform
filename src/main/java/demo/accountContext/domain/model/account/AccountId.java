package demo.accountContext.domain.model.account;

import demo.accountContext.shared.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class AccountId implements ValueObject<AccountId> {
    private String id;

    public static AccountId nextId() {
        return new AccountId(UUID.randomUUID().toString());
    }

    @Override
    public boolean sameValueAs(AccountId other) {
        return equals(other);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountId accountId = (AccountId) o;
        return Objects.equals(id, accountId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id;
    }
}
