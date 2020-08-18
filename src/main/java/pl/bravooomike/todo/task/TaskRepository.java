package pl.bravooomike.todo.task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {

    List<TaskEntity> findByUserId(Integer id);
    Optional<TaskEntity> findByIdAndUserId(Integer taskId, Integer userId);

}
