package pl.bravooomike.todo.security.userIdentity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserIdentity {
    private Integer id;
    private String firstName;
    private String lastName;
//    private String userRole;
    private List<String> userRoles;
}
