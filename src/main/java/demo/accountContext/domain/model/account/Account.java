package demo.accountContext.domain.model.account;

import demo.accountContext.domain.service.RoleDto;
import demo.accountContext.shared.Entity;
import demo.accountContext.shared.ValueObject;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(of = {"accountId"})
public class Account implements Entity<Account> {
    private static String APP_OWNER = "appOwner";

    private AccountId accountId;
    private String name;
    private List<Role> roles;
    private LocalDateTime createTime;

    private Account(AccountId accountId, String name, List<Role> roles) {
        this.accountId = accountId;
        this.name = name;
        this.roles = roles;
        createTime = LocalDateTime.now();
    }

    public static Account assemble(AccountId accountId, String name, List<Role> roles) {
        validateRole(roles);
        return new Account(accountId, name, roles);
    }

    private static void validateRole(List<Role> roles) {
        roles.forEach(role -> {
            if (APP_OWNER.equals(role.name)) {
                throw new IllegalRoleException(role.name);
            }
        });
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    @Override
    public boolean sameIdentityAs(Account other) {
        return accountId.sameValueAs(other.getAccountId());
    }

    public void reassemble(String name, List<Role> roles) {
        validateRole(roles);
        this.name = name;
    }

    @Getter
    @AllArgsConstructor
    public static class Role implements ValueObject<Role> {
        private String roleId;
        private String name;

        @Override
        public boolean sameValueAs(Role other) {
            return false;
        }
    }
}
