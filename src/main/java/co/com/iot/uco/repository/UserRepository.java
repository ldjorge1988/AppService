package co.com.iot.uco.repository;

import co.com.iot.uco.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //User findUserByIdentification(Long identification);
    User findUserById(long id);

    User findUserByEmail(String email);
   
}
