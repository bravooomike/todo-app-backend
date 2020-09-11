package pl.bravooomike.todo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.bravooomike.todo.taskStatus.TaskStatusConverter;
import pl.bravooomike.todo.taskType.TaskTypeConverter;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskConverter {

    private TaskTypeConverter taskTypeConverter;
    private TaskStatusConverter taskStatusConverter;

    @Autowired
    public TaskConverter(TaskTypeConverter taskTypeConverter, TaskStatusConverter taskStatusConverter) {
        this.taskTypeConverter = taskTypeConverter;
        this.taskStatusConverter = taskStatusConverter;
    }

    public TaskDto toDto(TaskEntity taskEntity) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(taskEntity.getId());
        taskDto.setSummary(taskEntity.getSummary());
        taskDto.setContent(taskEntity.getContent());
        taskDto.setTaskType(taskTypeConverter.toDto(taskEntity.getTaskType()));
        taskDto.setTaskStatus(taskStatusConverter.toDto(taskEntity.getTaskStatus()));
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
        taskEntity.setTaskType(taskTypeConverter.toEntity(taskDto.getTaskType()));
        taskEntity.setTaskStatus(taskStatusConverter.toEntity(taskDto.getTaskStatus()));
        taskEntity.setCreatedDate(taskDto.getCreatedDate());
        taskEntity.setExpiredDate(taskDto.getExpiredDate());
        taskEntity.setEndedDate(taskDto.getEndedDate());
        taskEntity.setUserId(taskDto.getUserId());
        return taskEntity;
    }
}
