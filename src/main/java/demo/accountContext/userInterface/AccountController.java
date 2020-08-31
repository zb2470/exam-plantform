package demo.accountContext.userInterface;

import demo.accountContext.application.AccountApplicationService;
import demo.accountContext.application.AssembleAccountCommand;
import demo.accountContext.domain.model.account.Account;
import demo.accountContext.domain.model.account.AccountId;
import demo.accountContext.infrastructure.AccountReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    private final AccountApplicationService accountApplicationService;
    private final AccountReadRepository accountReadRepository;

    @Autowired
    public AccountController(AccountApplicationService accountApplicationService, AccountReadRepository accountReadRepository) {
        this.accountApplicationService = accountApplicationService;
        this.accountReadRepository = accountReadRepository;
    }

    @PostMapping("/accounts")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    AccountDTO assemble(@RequestBody AssembleAccountCommand command) {
        final AccountId accountId = accountApplicationService.assembleAccount(command);
        return AccountDTO.from(accountId);
    }

    @GetMapping("/accounts")
    List<Account> getAll() {
        return accountReadRepository.getAllByReversed();
    }

    @PutMapping("/accounts/{accountId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void reassemble(
            @PathVariable String accountId,
            @RequestBody AssembleAccountCommand command) {
        accountApplicationService.reassembleAccount(accountId, command);
    }
}
