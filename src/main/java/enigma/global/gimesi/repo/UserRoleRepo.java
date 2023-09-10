package enigma.global.gimesi.repo;

import enigma.global.gimesi.model.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface UserRoleRepo extends CrudRepository<UserRole, Integer> {

    UserRole findByRoleName(String userRole);
}
