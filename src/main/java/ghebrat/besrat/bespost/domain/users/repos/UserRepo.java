package ghebrat.besrat.bespost.domain.users.repos;

import ghebrat.besrat.bespost.domain.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByEmail (String email);


}
