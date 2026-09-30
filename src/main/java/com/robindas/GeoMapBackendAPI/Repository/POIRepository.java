package com.robindas.GeoMapBackendAPI.Repository;

import com.robindas.GeoMapBackendAPI.Models.POIS;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface POIRepository extends JpaRepository<POIS, Long> {

    @Query(value = "SELECT * FROM m2mdev.spatial_poi p WHERE ST_DWithin(CAST(p.geom AS geography), CAST(:point AS geography), :distanceMeters)" +
            "ORDER BY ST_distance(CAST(p.geom AS geography), CAST(:point AS geography)) ASC LIMIT 1", nativeQuery = true)
    Optional<POIS> findNearestPoi(@Param("point") Point point, @Param("distanceMeters") double distanceMeters);

}
