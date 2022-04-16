package iitu.kz.diploma.Repos;

import iitu.kz.diploma.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, Long>{
}
