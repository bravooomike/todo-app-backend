package pl.bravooomike.todo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.bravooomike.todo.security.userIdentity.IdentityProviderImplementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public Page<TaskDto> getAll(String filter, Boolean allTasks, Pageable pageable) {
        Integer userId = identityProviderImplementation.get().getId();

        System.out.println(filter);
        System.out.println(allTasks);

        List<String> taskStatusCodes = new ArrayList<>();
        taskStatusCodes.add("zap");
        taskStatusCodes.add("wtr");
        if (allTasks == true) {
            taskStatusCodes.add("zak");
        }

        Page<TaskEntity> result = null;
        if (filter == null || "".equals(filter)) {
           result = taskRepository.findByUserIdAndTaskStatus_CodeIn(userId, taskStatusCodes, pageable);
        } else {
            result = this.taskRepository.findBySummaryContainingIgnoreCaseAndUserIdAndTaskStatus_CodeIn(filter,
                    userId, taskStatusCodes, pageable);
        }

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
