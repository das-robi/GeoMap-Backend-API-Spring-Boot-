package com.robindas.GeoMapBackendAPI.Repository;

import com.robindas.GeoMapBackendAPI.Models.Districts;
import com.robindas.GeoMapBackendAPI.Models.Thana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<Districts, Integer> {

//    Districts findByPolyxPolyy(String polyx, String polyy);
}
