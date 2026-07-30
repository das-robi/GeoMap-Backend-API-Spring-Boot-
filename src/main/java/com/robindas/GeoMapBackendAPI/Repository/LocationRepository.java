package com.robindas.GeoMapBackendAPI.Repository;

import com.robindas.GeoMapBackendAPI.Models.POIS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<POIS, Integer> {
}
