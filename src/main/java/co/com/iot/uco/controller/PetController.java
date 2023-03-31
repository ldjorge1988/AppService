package co.com.iot.uco.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.iot.uco.dto.PetDTO;
import co.com.iot.uco.service.PetSerivice;
import lombok.RequiredArgsConstructor;
@CrossOrigin
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PetController {

    private final PetSerivice petService;
    
    @GetMapping("/pet")
    public ResponseEntity<List<PetDTO>> getpets(){
        return ResponseEntity.ok().body(petService.getPets());
    }

 

    @PostMapping("/pet")
    public ResponseEntity<Void> createpet(@RequestBody PetDTO petDTO){
        petService.createPet(petDTO);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/pet/{id}")
    public ResponseEntity<Void> deletepet(long id){
        petService.deletePet(id);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/pet")
    public ResponseEntity<Void> updatepet(@RequestBody PetDTO petDTO){
        petService.updatePet(petDTO);
        return ResponseEntity.accepted().build();
    }

    

    
}
