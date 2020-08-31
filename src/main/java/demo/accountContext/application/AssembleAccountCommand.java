package demo.accountContext.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.util.List;

@Data
@AllArgsConstructor
public class AssembleAccountCommand {
    private String name;
    private List<Role> roles;

    @Value
    public static class Role {
        private String id;
        private String name;
    }
}