package pl.bravooomike.todo.task;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {

    Page<TaskEntity> findBySummaryContainingIgnoreCaseAndUserIdAndTaskStatus_CodeIn (String summaryFilter,
    Integer id, List<String> codes, Pageable pageable);

    Page<TaskEntity> findByUserIdAndTaskStatus_CodeIn(Integer id, List<String> codes, Pageable pageable);

    Optional<TaskEntity> findByIdAndUserId(Integer taskId, Integer userId);

}
