package co.com.iot.uco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.iot.uco.model.Pet;
@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    Pet findPetById(long id);
    
}
