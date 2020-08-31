package demo.accountContext.userInterface;

import demo.accountContext.domain.model.account.AccountId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AccountDTO {
    private String uri;

    public static AccountDTO from(AccountId accountId) {
        return new AccountDTO("accounts/" + accountId);
    };
}
