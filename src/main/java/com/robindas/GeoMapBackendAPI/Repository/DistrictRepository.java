package com.robindas.GeoMapBackendAPI.Repository;

import com.robindas.GeoMapBackendAPI.Models.Districts;
import com.robindas.GeoMapBackendAPI.Models.Thana;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DistrictRepository extends JpaRepository<Districts, Long> {

    @Query(value = "SELECT * FROM m2mdev.spatial_district d WHERE ST_Contains(d.geom, :point) LIMIT 1", nativeQuery = true)
    Optional<Districts> findContainingDistrict(@Param("point")Point point);
}
