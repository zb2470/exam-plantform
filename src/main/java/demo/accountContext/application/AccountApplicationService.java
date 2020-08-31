package demo.accountContext.application;

import demo.accountContext.domain.model.account.Account;
import demo.accountContext.domain.model.account.AccountId;
import demo.accountContext.domain.model.account.AccountRepository;
import demo.accountContext.domain.service.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class AccountApplicationService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountApplicationService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountId assembleAccount(AssembleAccountCommand command) {
        List<RoleDto> roleDtos = roleFrom(command);
        final AccountId accountId = AccountId.nextId();

        final Account account = Account.assemble(accountId, command.getName(), roleDtos.stream()
                .map(RoleDto::toRole)
                .collect(toList()));
        accountRepository.save(account);
        return accountId;
    }

    public void reassembleAccount(String accountId, AssembleAccountCommand command) {
        final Account account = accountRepository.find(new AccountId(accountId));
        List<RoleDto> roleDtos = roleFrom(command);

        account.reassemble(command.getName(), roleDtos.stream()
                .map(RoleDto::toRole)
                .collect(toList()));
    }

    private List<RoleDto> roleFrom(AssembleAccountCommand command) {
        return command.getRoles().stream().map(role -> new RoleDto(role.getId(),
                role.getName())).collect(toList());
    }
}
