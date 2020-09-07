package pl.bravooomike.todo.task;

import lombok.Getter;
import lombok.Setter;
import pl.bravooomike.todo.taskType.TaskTypeDto;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Getter
@Setter
public class TaskDto {

    private Integer id;
    private String summary;
    private String content;
    private TaskTypeDto taskType;
    private String taskStatusCode;
    private OffsetDateTime createdDate;
    private OffsetDateTime expiredDate;
    private OffsetDateTime endedDate;
    private Integer userId;

}
