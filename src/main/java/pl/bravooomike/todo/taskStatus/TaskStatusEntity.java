package pl.bravooomike.todo.taskStatus;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "task_status")
@Getter
@Setter
public class TaskStatusEntity {

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
}
