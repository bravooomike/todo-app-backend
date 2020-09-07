package pl.bravooomike.todo.taskType;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.io.Serializable;

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
}
