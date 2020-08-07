package pl.bravooomike.todo.task;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskConverter {

    public TaskDto toDto(TaskEntity taskEntity) {
        TaskDto taskDto = new TaskDto();
        taskDto.setSummary(taskEntity.getSummary());
        taskDto.setContent(taskEntity.getContent());
        taskDto.setTaskTypeCode(taskEntity.getTaskTypeCode());
        taskDto.setTaskStatusCode(taskEntity.getTaskStatusCode());
        taskDto.setCreatedDate(taskEntity.getCreatedDate());
        taskDto.setExpiredDate(taskEntity.getExpiredDate());
        taskDto.setEndedDate(taskEntity.getEndedDate());
        taskDto.setUserId(taskEntity.getUserId());
        return taskDto;
    }

    public List<TaskDto> toDtos(List<TaskEntity> taskEntities) {
        List<TaskDto> taskDtos = new ArrayList<>();
        for (int i = 0; i < taskEntities.size(); i++) {
            taskDtos.add(toDto(taskEntities.get(i)));
        }
        return taskDtos;
    }

    public TaskDto getOne(TaskEntity taskEntity) {
        return toDto(taskEntity);
    }

    public TaskEntity toEntity(TaskDto taskDto, TaskEntity previousTaskEntity) {
        TaskEntity taskEntity;
        if(previousTaskEntity == null) {
            taskEntity = new TaskEntity();
        } else {
            taskEntity = previousTaskEntity;
        }
        taskEntity.setSummary(taskDto.getSummary());
        taskEntity.setContent(taskDto.getContent());
        taskEntity.setTaskTypeCode(taskDto.getTaskTypeCode());
        taskEntity.setTaskStatusCode(taskDto.getTaskStatusCode());
        taskEntity.setCreatedDate(taskDto.getCreatedDate());
        taskEntity.setExpiredDate(taskDto.getExpiredDate());
        taskEntity.setEndedDate(taskDto.getEndedDate());
        taskEntity.setUserId(taskDto.getUserId());
        return taskEntity;
    }
}
