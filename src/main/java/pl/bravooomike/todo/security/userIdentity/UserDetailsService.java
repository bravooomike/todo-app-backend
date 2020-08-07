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

    private UserRepository userRepository;

    @Autowired
    public UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    User loadByName(String name) {
        UserEntity userEntity = this.userRepository.findByName(name);
        return new User(userEntity.getFirstName(), userEntity.getPassword(), Collections.singleton(new SimpleGrantedAuthority(userEntity.getUserRole())));
    }
}
