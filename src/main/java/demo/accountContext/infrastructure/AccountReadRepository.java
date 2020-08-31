package demo.accountContext.infrastructure;

import demo.accountContext.domain.model.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountReadRepository {
    public final MemoryAccountRepository memoryAccountRepository;

    @Autowired
    public AccountReadRepository(MemoryAccountRepository memoryAccountRepository) {
        this.memoryAccountRepository = memoryAccountRepository;
    }

    public List<Account> getAllByReversed() {
        // 如果是第三方数据库，可以直接连接数据库(读库)
        return memoryAccountRepository.getAll();
    }
}
