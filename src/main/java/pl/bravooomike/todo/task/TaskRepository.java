package pl.bravooomike.todo.task;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {

    Page<TaskEntity> findByUserId(Integer id, Pageable pageable);
    Optional<TaskEntity> findByIdAndUserId(Integer taskId, Integer userId);

}
