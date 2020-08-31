package demo.accountContext.domain.model.account;

import java.util.List;

public interface AccountRepository {
    Account find(AccountId accountId);

    void save(Account account);

    List<Account> getAll();
}
