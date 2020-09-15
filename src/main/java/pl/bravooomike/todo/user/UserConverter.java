package pl.bravooomike.todo.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter {

    public UserDto toDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setFirstName(userEntity.getFirstName());
        userDto.setLastName(userEntity.getLastName());
        userDto.setEmail(userEntity.getEmail());
        userDto.setPassword(userEntity.getPassword());
        userDto.setUserRole(userEntity.getUserRole());
        userDto.setActive(userEntity.getActive());
        return userDto;
    }

    public List<UserDto> toDtos(List<UserEntity> userEntities) {
        List<UserDto> userDtos = new ArrayList<>();
        for (int i = 0; i < userEntities.size(); i++) {
            userDtos.add(toDto(userEntities.get(i)));
        }
        return userDtos;
    }

    public UserDto getOne(UserEntity userEntity) {
        return toDto(userEntity);
    }

    public UserEntity toEntity(UserDto userDto, UserEntity previousUserEntity) {
        UserEntity userEntity;
        if(previousUserEntity == null) {
            userEntity = new UserEntity();
        } else {
            userEntity = previousUserEntity;
        }
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setUserRole(userDto.getUserRole());
        userEntity.setActive(userDto.getActive());
        return userEntity;
    }
}
