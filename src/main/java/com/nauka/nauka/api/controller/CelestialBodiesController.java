package com.nauka.nauka.api.controller;

import com.nauka.nauka.entity.CelestialBodies;
import com.nauka.nauka.entity.Customer;
import com.nauka.nauka.repository.ICelestialBodiesRepo;
import com.nauka.nauka.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CelestialBodiesController {

    private ICelestialBodiesRepo celestialBodiesRepo;

    @Autowired
    public CelestialBodiesController(ICelestialBodiesRepo celestialBodiesRepo) {
        this.celestialBodiesRepo = celestialBodiesRepo;
    }

    @PostMapping("/celestialbodies")
    public ResponseEntity<CelestialBodies> save(@RequestBody CelestialBodies celestialBodies) {
        try {
            return new ResponseEntity<>(celestialBodiesRepo.save(celestialBodies), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/celestialbodies")
    public ResponseEntity<List<CelestialBodies>> getAllCelestialBodies() {
        try {
            List<CelestialBodies> list = celestialBodiesRepo.findAll();
            if(list.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/celestialBodies/{id}")
    public ResponseEntity<CelestialBodies> getSingleCelestialBody(@PathVariable Long id) {
        Optional<CelestialBodies> celestialBodies = celestialBodiesRepo.findById(id);
        return celestialBodies
            .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/celestialBodies/{id}")
    public ResponseEntity<CelestialBodies> updateCelestialBodies(@RequestBody CelestialBodies celestialBodies) {
        try {
            return new ResponseEntity<>(celestialBodiesRepo.save(celestialBodies), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/celestialBodies/{id}")
    public ResponseEntity<HttpStatus> deleteCelestialBodies(@PathVariable Long id) {
        try {
            Optional<CelestialBodies> celestialBodies = celestialBodiesRepo.findById(id);
            celestialBodies.ifPresent(bodies -> celestialBodiesRepo.delete(bodies));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
