package pl.bravooomike.todo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;
    private TaskConverter taskConverter;

    @Autowired
    public TaskService(TaskRepository taskRepository, TaskConverter taskConverter) {
        this.taskRepository = taskRepository;
        this.taskConverter = taskConverter;
    }

    public List<TaskDto> getAll() {
        return taskConverter.toDtos(taskRepository.findAll());
    }

    public TaskDto getOne(Integer id) {
        return taskConverter.getOne(taskRepository.findById(id).orElse(null));
    }

    public TaskDto save(TaskDto taskDto, Integer id) {
        TaskEntity savedTaskEntity;
        if(id == null) {
            savedTaskEntity = taskRepository.save(taskConverter.toEntity(taskDto, null));
        } else {
            savedTaskEntity = taskRepository.save(taskConverter.toEntity(taskDto, taskRepository.getOne(id)));
        }
        return taskConverter.toDto(savedTaskEntity);
    }
}
