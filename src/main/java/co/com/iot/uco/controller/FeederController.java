package co.com.iot.uco.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.iot.uco.dto.FeederDTO;
import co.com.iot.uco.service.FeederService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FeederController {

    private final FeederService feederService;

    @GetMapping("/feeder")
    public ResponseEntity<List<FeederDTO>> getpets(){
        return ResponseEntity.ok().body(feederService.getFeeders());
    }

 

    @PostMapping("/feeder")
    public ResponseEntity<Void> createpet(FeederDTO feederDto){
        feederService.createFeeder(feederDto);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/feeder/{id}")
    public ResponseEntity<Void> deletepet(long id){
        feederService.deleteFeeder(id);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/feeder")
    public ResponseEntity<Void> updatepet(FeederDTO feederDto){
        feederService.updateFeeder(feederDto);
        return ResponseEntity.accepted().build();
    }
    
}
