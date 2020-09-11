package pl.bravooomike.todo.taskStatus;

import lombok.Getter;
import lombok.Setter;
import pl.bravooomike.todo.task.TaskEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "task_status")
@Getter
@Setter
public class TaskStatusEntity implements Serializable {

    @Id
    @SequenceGenerator(
            name = "taskStatusEntityIdSequence",
            sequenceName = "task_status_id_seq",
            initialValue = 4,
            allocationSize = 1
    )
    @GeneratedValue(generator = "taskStatusEntityIdSequence")
    @Column(name = "id")
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "active")
    private Boolean active;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taskStatus")
    private Set<TaskEntity> tasks;

    public void addTask(TaskEntity taskEntity) {
        if (tasks == null) {
            tasks = new HashSet<>();
        }
        if (!tasks.contains(taskEntity)) {
            tasks.add(taskEntity);
        }
    }
}
