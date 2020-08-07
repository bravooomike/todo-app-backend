package pl.bravooomike.todo.security.userIdentity;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IdentityProviderImplementation {

    public UserIdentity get() {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserIdentity userIdentity = new UserIdentity();
        userIdentity.setUsername(principal.getUsername());
        userIdentity.setUserRole(principal.getAuthorities().toString());

//        List<String> userRoleList = new ArrayList<>();
//        for (int i = 0; i < principal.getAuthorities().size(); i++) {
//            userRoleList.add(principal.getAuthorities().toArray()[i].toString());
//        }

//        userIdentity.setUserRole(userRoleList.get(0));
//        userIdentity.setUserRoles(userRoleList);
        return userIdentity;
    }
}
