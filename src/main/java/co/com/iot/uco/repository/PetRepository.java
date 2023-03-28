package co.com.iot.uco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.iot.uco.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

    Pet findPetById(long id);
    
}
