package pl.bravooomike.todo.taskType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskTypeService {

    private TaskTypeConverter taskTypeConverter;
    private TaskTypeRepository taskTypeRepository;

    @Autowired
    public TaskTypeService(TaskTypeConverter taskTypeConverter, TaskTypeRepository taskTypeRepository) {
        this.taskTypeConverter = taskTypeConverter;
        this.taskTypeRepository = taskTypeRepository;
    }

    public List<TaskTypeDto> getAll() {
        return taskTypeConverter.toDtos(taskTypeRepository.findAll());
    }

    public TaskTypeDto getOne(Integer id) {
        return taskTypeConverter.toDto(taskTypeRepository.getOne(id));
    }

    public TaskTypeDto save(TaskTypeDto taskTypeDto) {
        return taskTypeConverter.toDto(taskTypeRepository.save(taskTypeConverter.toEntity(taskTypeDto)));
    }

    public  TaskTypeDto save(TaskTypeDto taskTypeDto, Integer id) {
        TaskTypeEntity taskTypeEntity = taskTypeRepository.getOne(id);
        TaskTypeEntity savedTaskTypeEntity = taskTypeRepository.save(taskTypeConverter.toEntity(taskTypeDto, taskTypeEntity));
        return taskTypeConverter.toDto(savedTaskTypeEntity);
    }
}
