package demo.accountContext.domain.model.account;

public class IllegalRoleException extends IllegalArgumentException {
    public IllegalRoleException(String name) {
        super("IllegalRoleException: The role cannot be an :" + name);
    }
}
