package com.nauka.nauka.repository;

import com.nauka.nauka.entity.CelestialBodies;
import com.nauka.nauka.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ICelestialBodiesRepo extends JpaRepository<CelestialBodies, Long> {
}
