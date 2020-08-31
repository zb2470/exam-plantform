package demo.accountContext.infrastructure;

import demo.accountContext.domain.model.account.Account;
import demo.accountContext.domain.model.account.AccountId;
import demo.accountContext.domain.model.account.AccountRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MemoryAccountRepository implements AccountRepository {
    private Set<Account> accounts = new HashSet<>();

    @Override
    public Account find(AccountId accountId) {
        return accounts.stream().filter(account -> account.getAccountId()
                .equals(accountId))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }

    @Override
    public void save(Account account) {
        accounts.add(account);
    }

    @Override
    public List<Account> getAll() {
        return accounts.stream().collect(Collectors.toList());
    }
}