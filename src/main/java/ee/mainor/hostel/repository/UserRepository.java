package ee.mainor.hostel.repository;

import ee.mainor.hostel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
