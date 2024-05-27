package co.develhope.UnitTest.repositories;

import co.develhope.UnitTest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
