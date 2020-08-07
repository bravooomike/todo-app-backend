package pl.bravooomike.todo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserConverter userConverter;

    @Autowired
    public UserService(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    public List<UserDto> getAll() {
        return userConverter.toDtos(userRepository.findAll());
    }

    public UserDto getOne(Integer id) {
        return userConverter.getOne(userRepository.getOne(id));
    }

    public UserDto save(UserDto userDto, Integer id) {
        UserEntity savedUserEntity;
        if(id == null) {
            savedUserEntity = userRepository.save(userConverter.toEntity(userDto, null));
        } else {
            savedUserEntity = userRepository.save(userConverter.toEntity(userDto, userRepository.getOne(id)));
        }
        return userConverter.toDto(savedUserEntity);
    }
}
