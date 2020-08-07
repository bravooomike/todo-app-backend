package pl.bravooomike.todo.task;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class TaskDto {

    private Integer id;
    private String summary;
    private String content;
    private String taskTypeCode;
    private String taskStatusCode;
    private OffsetDateTime createdDate;
    private OffsetDateTime expiredDate;
    private OffsetDateTime endedDate;
    private Integer userId;

}
