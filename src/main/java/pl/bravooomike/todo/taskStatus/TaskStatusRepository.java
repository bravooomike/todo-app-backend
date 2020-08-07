package pl.bravooomike.todo.taskStatus;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskStatusRepository extends JpaRepository<TaskStatusEntity, Integer> {
}
