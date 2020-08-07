package pl.bravooomike.todo.taskType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskTypeDto {

    private Integer id;
    private String code;
    private String name;
    private Boolean active;
}
