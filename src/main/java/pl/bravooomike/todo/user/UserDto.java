package pl.bravooomike.todo.user;

import lombok.Getter;
import lombok.Setter;
import pl.bravooomike.todo.task.TaskEntity;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String userRole;
    private Boolean active;
    private List<TaskEntity> tasks;
}
