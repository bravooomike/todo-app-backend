package pl.bravooomike.todo.security.userIdentity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "\"user\"")
@Getter
@Setter
public class UserIdentityEntity {

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

    @Enumerated(EnumType.STRING)
    @Column(name ="role")
    private UserIdentityRole userRole;

    @Column(name ="active")
    private Boolean active;


}
