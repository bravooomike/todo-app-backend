package pl.bravooomike.todo.taskStatus;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskStatusConverter {

    private TaskStatusRepository taskStatusRepository;

    public TaskStatusDto toDto(TaskStatusEntity taskStatusEntity) {
        TaskStatusDto taskStatusDto = new TaskStatusDto();
        taskStatusDto.setCode(taskStatusEntity.getCode());
        taskStatusDto.setName(taskStatusEntity.getName());
        taskStatusDto.setActive(taskStatusEntity.getActive());
        return  taskStatusDto;
    }

    public List<TaskStatusDto> toDtos(List<TaskStatusEntity> taskStatusEntities) {
        List<TaskStatusDto> taskStatusDtos = new ArrayList<>();
        for (int i = 0; i < taskStatusEntities.size(); i++) {
            taskStatusDtos.add(toDto(taskStatusEntities.get(i)));
        }
        return taskStatusDtos;
    }

    public TaskStatusDto getOne(Integer id) {
        return toDto(taskStatusRepository.getOne(id));
    }

    public TaskStatusEntity toEntity(TaskStatusDto taskStatusDto, TaskStatusEntity previousTaskStatusEntity) {
        TaskStatusEntity taskStatusEntity;
        if (previousTaskStatusEntity == null) {
            taskStatusEntity = new TaskStatusEntity();
        } else {
            taskStatusEntity = previousTaskStatusEntity;
        }
        taskStatusEntity.setCode(taskStatusDto.getCode());
        taskStatusEntity.setName(taskStatusDto.getName());
        taskStatusEntity.setActive(taskStatusDto.getActive());
        return taskStatusEntity;
    }

    public TaskStatusEntity toEntity(TaskStatusDto taskStatusDto) {
        return toEntity(taskStatusDto, null);
    }
}
