package co.com.iot.uco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.iot.uco.model.Feeder;

public interface FeederRepository extends JpaRepository<Feeder, Long> {
    Feeder findFeederById(long id);
    
}
