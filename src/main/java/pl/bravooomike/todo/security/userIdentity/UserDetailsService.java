package pl.bravooomike.todo.security.userIdentity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import pl.bravooomike.todo.user.UserRepository;
import pl.bravooomike.todo.user.UserEntity;

import java.util.Collections;

@Service
public class UserDetailsService {

    private UserIdentityRepository userIdentityRepository;

    @Autowired
    public UserDetailsService(UserIdentityRepository userIdentityRepository) {
        this.userIdentityRepository = userIdentityRepository;
    }

    User loadByEmail(String email) {
        UserIdentityEntity userEntity = this.userIdentityRepository.findByEmail(email);

//        if (userEntity.getUserRole() == UserIdentityRole.USER) {
//            return null;
//        }

        return new CustomUser(userEntity.getFirstName(), userEntity.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(userEntity.getUserRole().toString())), userEntity.getId());
    }
}
