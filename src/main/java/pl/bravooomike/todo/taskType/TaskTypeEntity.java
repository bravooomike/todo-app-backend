package pl.bravooomike.todo.taskType;

import lombok.Getter;
import lombok.Setter;
import pl.bravooomike.todo.task.TaskEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "task_type")
@Getter
@Setter
public class TaskTypeEntity implements Serializable {

    @Id
    @SequenceGenerator(
            name = "taskTypeEntityIdSequence",
            sequenceName = "task_type_id_seq",
            initialValue = 4,
            allocationSize = 1
    )
    @GeneratedValue(generator = "taskTypeEntityIdSequence")
    @Column(name = "id")
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "active")
    private Boolean active;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taskType")
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
