package pl.bravooomike.todo.security.userIdentity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserIdentityRepository extends JpaRepository<UserIdentityEntity, Integer> {

    UserIdentityEntity findByEmail(String email);
}
