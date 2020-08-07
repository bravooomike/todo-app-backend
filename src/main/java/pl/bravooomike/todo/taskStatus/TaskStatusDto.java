package pl.bravooomike.todo.taskStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskStatusDto {

    private Integer id;
    private String code;
    private String name;
    private Boolean active;
}
