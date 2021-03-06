package pl.bravooomike.todo.task;

import lombok.Getter;
import lombok.Setter;
import pl.bravooomike.todo.taskStatus.TaskStatusEntity;
import pl.bravooomike.todo.taskType.TaskTypeEntity;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "task")
@Getter
@Setter
public class TaskEntity {

    @Id
    @SequenceGenerator(
            name = "taskEntityIdSequence",
            sequenceName = "task_id_seq",
            initialValue = 4,
            allocationSize = 1
    )
    @GeneratedValue(generator = "taskEntityIdSequence")
    @Column(name = "id")
    private Integer id;

    @Column(name = "summary")
    private String summary;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "task_type_code", referencedColumnName = "code")
    // @Column(name = "task_type_code")
    // private String taskTypeCode;
    private TaskTypeEntity taskType;

    @ManyToOne
    @JoinColumn(name = "task_status_code", referencedColumnName = "code")
    // @Column(name = "task_status_code")
    // private String taskStatusCode;
    private TaskStatusEntity taskStatus;

    @Column(name = "created_date")
    private OffsetDateTime createdDate;

    @Column(name = "expired_date")
    private OffsetDateTime expiredDate;

    @Column(name = "ended_date")
    private OffsetDateTime endedDate;

    @Column(name = "user_id")
    private Integer userId;

    public void setTaskType(TaskTypeEntity taskType) {
        this.taskType = taskType;
        taskType.addTask(this);
    }

    public void setTaskStatus(TaskStatusEntity taskStatus) {
        this.taskStatus = taskStatus;
        taskStatus.addTask(this);
    }
}
