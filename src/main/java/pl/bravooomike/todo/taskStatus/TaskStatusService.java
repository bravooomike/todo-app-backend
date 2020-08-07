package pl.bravooomike.todo.taskStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskStatusService {

    private TaskStatusRepository taskStatusRepository;
    private TaskStatusConverter taskStatusConverter;

    @Autowired
    public TaskStatusService(TaskStatusRepository taskStatusRepository, TaskStatusConverter taskStatusConverter) {
        this.taskStatusRepository = taskStatusRepository;
        this.taskStatusConverter = taskStatusConverter;
    }

    public List<TaskStatusDto> getAll() {
        return taskStatusConverter.toDtos(taskStatusRepository.findAll());
    }

    public  TaskStatusDto getOne(Integer id) {
        return taskStatusConverter.toDto(taskStatusRepository.getOne(id));
    }

    public TaskStatusDto save(TaskStatusDto taskStatusDto, Integer id) {
        TaskStatusEntity taskStatusEntity = taskStatusRepository.getOne(id);
        return taskStatusConverter.toDto(taskStatusRepository.save(taskStatusConverter.toEntity(taskStatusDto, taskStatusEntity)));
    }

    public TaskStatusDto save(TaskStatusDto taskStatusDto) {
        return taskStatusConverter.toDto(taskStatusRepository.save(taskStatusConverter.toEntity(taskStatusDto)));
    }
}
