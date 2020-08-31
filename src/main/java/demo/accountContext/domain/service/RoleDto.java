package demo.accountContext.domain.service;

import demo.accountContext.domain.model.account.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RoleDto {
    private String roleId;
    private String name;

    public static Account.Role toRole(RoleDto roleDto) {
        return new Account.Role(roleDto.getRoleId(), roleDto.name);
    }
}
