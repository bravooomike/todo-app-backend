package pl.bravooomike.todo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.bravooomike.todo.security.userIdentity.IdentityProviderImplementation;

@Service
public class TaskService {

    private TaskRepository taskRepository;
    private TaskConverter taskConverter;
    private IdentityProviderImplementation identityProviderImplementation;

    @Autowired
    public TaskService(TaskRepository taskRepository, TaskConverter taskConverter, IdentityProviderImplementation identityProviderImplementation) {
        this.taskRepository = taskRepository;
        this.taskConverter = taskConverter;
        this.identityProviderImplementation = identityProviderImplementation;
    }

    public Page<TaskDto> getAll(Pageable pageable) {
        Integer userId = identityProviderImplementation.get().getId();
        Page<TaskEntity> result = taskRepository.findByUserId(userId, pageable);
        return result.map(el -> taskConverter.toDto(el));
    }

    public TaskDto getOne(Integer id) {
        Integer userId = identityProviderImplementation.get().getId();
        return taskConverter.getOne(taskRepository.findByIdAndUserId(id, userId).orElse(null));
    }

    public TaskDto save(TaskDto taskDto, Integer id) {
        TaskEntity savedTaskEntity;
        Integer userId = identityProviderImplementation.get().getId();
        taskDto.setUserId(userId);
        if(id == null) {
            savedTaskEntity = taskRepository.save(taskConverter.toEntity(taskDto, null));
        } else {
            savedTaskEntity = taskRepository.save(taskConverter.toEntity(taskDto, taskRepository.getOne(id)));
        }
        return taskConverter.toDto(savedTaskEntity);
    }

    public void deleteOne(Integer id) {
        taskRepository.deleteById(id);
    }
}
