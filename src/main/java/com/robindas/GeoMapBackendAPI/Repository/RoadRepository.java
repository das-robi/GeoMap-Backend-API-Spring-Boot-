package com.robindas.GeoMapBackendAPI.Repository;

import com.robindas.GeoMapBackendAPI.Models.Road;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoadRepository extends JpaRepository<Road, Integer> {
    List<Road> findByDescriptionContainingIgnoreCase(String keyword);
}
