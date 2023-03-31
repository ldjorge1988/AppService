package co.com.iot.uco.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import co.com.iot.uco.dto.FeederDTO;
import co.com.iot.uco.service.FeederService;
import lombok.RequiredArgsConstructor;
@CrossOrigin
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
    public ResponseEntity<Void> createpet(@RequestBody FeederDTO feederDto){
        feederService.createFeeder(feederDto);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/feeder/{id}")
    public ResponseEntity<Void> deletepet( long id){
        feederService.deleteFeeder(id);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/feeder")
    public ResponseEntity<Void> updatepet(@RequestBody FeederDTO feederDto){
        feederService.updateFeeder(feederDto);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/feeder/{serial}")
    public ResponseEntity<FeederDTO> getBySerial(@PathVariable String serial){
        return ResponseEntity.ok(feederService.getFeederBySerial(serial));
    }

}
