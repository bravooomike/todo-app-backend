package pl.bravooomike.todo.taskType;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskTypeConverter {

    public TaskTypeDto toDto(TaskTypeEntity taskTypeEntity) {
        TaskTypeDto taskTypeDto = new TaskTypeDto();
        taskTypeDto.setId(taskTypeEntity.getId());
        taskTypeDto.setCode(taskTypeEntity.getCode());
        taskTypeDto.setName(taskTypeEntity.getName());
        taskTypeDto.setActive(taskTypeEntity.getActive());
        return taskTypeDto;
    }

    public List<TaskTypeDto> toDtos(List<TaskTypeEntity> taskTypeEntities) {
        List<TaskTypeDto> taskTypeDtos = new ArrayList<>();
        for (int i = 0; i < taskTypeEntities.size(); i++) {
            taskTypeDtos.add(toDto(taskTypeEntities.get(i)));
        }
        return taskTypeDtos;
    }

    public TaskTypeDto getOne(TaskTypeEntity taskTypeEntity) {
        return toDto(taskTypeEntity);
    }

    public TaskTypeEntity toEntity(TaskTypeDto taskTypeDto, TaskTypeEntity previousTaskTypeEntity) {
        TaskTypeEntity taskTypeEntity;
        if (previousTaskTypeEntity == null) {
            taskTypeEntity = new TaskTypeEntity();
        } else {
            taskTypeEntity = previousTaskTypeEntity;
        }
        taskTypeEntity.setId(taskTypeDto.getId());
        taskTypeEntity.setCode(taskTypeDto.getCode());
        taskTypeEntity.setName(taskTypeDto.getName());
        taskTypeEntity.setActive(taskTypeDto.getActive());
        return taskTypeEntity;
    }

    public TaskTypeEntity toEntity(TaskTypeDto taskTypeDto) {
        return toEntity(taskTypeDto, null);
    }
}
