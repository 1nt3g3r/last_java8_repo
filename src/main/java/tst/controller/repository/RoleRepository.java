package tst.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tst.controller.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
