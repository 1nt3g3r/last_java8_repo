package tst.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tst.controller.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
