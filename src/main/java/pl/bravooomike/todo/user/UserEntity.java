package pl.bravooomike.todo.user;

import lombok.Getter;
import lombok.Setter;
import pl.bravooomike.todo.task.TaskEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
public class UserEntity {

    @Id
    @SequenceGenerator(
            name = "userEntityIdSequence",
            sequenceName = "user_id_seq",
            initialValue = 4,
            allocationSize = 1
    )
    @GeneratedValue(generator = "userEntityIdSequence")
    @Column(name = "id")
    private Integer id;

    @Column(name ="first_name")
    private String firstName;

    @Column(name ="last_name")
    private String lastName;

    @Column(name ="email")
    private String email;

    @Column(name ="password")
    private String password;

    @Column(name ="role")
    private String userRole;

    @Column(name ="active")
    private Boolean active;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<TaskEntity> tasks;
}
