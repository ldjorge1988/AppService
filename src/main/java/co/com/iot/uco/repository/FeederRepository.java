package co.com.iot.uco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.iot.uco.model.Feeder;
@Repository
public interface FeederRepository extends JpaRepository<Feeder, Long> {
    Feeder findFeederById(long id);
    
}
