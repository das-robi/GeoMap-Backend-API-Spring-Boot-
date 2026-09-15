package com.robindas.GeoMapBackendAPI.Repository;

import com.robindas.GeoMapBackendAPI.Models.Thana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThanaRepository extends JpaRepository<Thana, Integer> {


    List<Thana> findByDistricts_Id(int id);

    List<Thana> findByPolyxandPoly(double latitude, double longitude);
}
