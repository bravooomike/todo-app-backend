package pl.bravooomike.todo.security.userIdentity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserIdentity {
    private Integer id;
    private String firstName;
    private String lastName;
    private String userRole;
}
