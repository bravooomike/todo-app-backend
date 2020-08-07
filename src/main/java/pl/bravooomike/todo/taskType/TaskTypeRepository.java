package pl.bravooomike.todo.taskType;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskTypeRepository extends JpaRepository<TaskTypeEntity, Integer> {
}
