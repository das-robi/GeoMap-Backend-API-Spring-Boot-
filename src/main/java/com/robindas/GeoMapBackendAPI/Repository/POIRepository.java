package com.robindas.GeoMapBackendAPI.Repository;

import com.robindas.GeoMapBackendAPI.Models.POIS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface POIRepository extends JpaRepository<POIS, Integer> {

    List<POIS> findByDescriptionContainingIgnoreCase(String keyword);

    List<POIS> findByThana_Id(int thanaId);

    List<POIS> findByDistricts_Id(int distId);
}
