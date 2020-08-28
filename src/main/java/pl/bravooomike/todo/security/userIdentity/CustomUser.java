package pl.bravooomike.todo.security.userIdentity;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class CustomUser extends User {

    private Integer id;
    private String lastname;

    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities,
                      Integer id, String lastname) {
        super(username, password, authorities);
        this.id = id;
        this.lastname = lastname;
    }
}
