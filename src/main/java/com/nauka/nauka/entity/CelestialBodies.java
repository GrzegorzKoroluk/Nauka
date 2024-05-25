package com.nauka.nauka.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Table(name="CELESTIAL_BODIES")
@Entity
@Data
public class CelestialBodies {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long diameterKm;

    private Long distanceFromTheSunKm;

    @CreationTimestamp
    @Column(name="created_at", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    private Date updateAt;

}
