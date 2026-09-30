package com.robindas.GeoMapBackendAPI.Repository;

import com.robindas.GeoMapBackendAPI.Models.Road;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface RoadRepository extends JpaRepository<Road, Long> {

    @Query(value = "SELECT * FROM m2mdev.spatial_road r WHERE ST_DWithin(CAST(r.geom AS geography), CAST(:point AS geography), :distanceMeters) " +
            " ORDER BY ST_Distance(CAST(r.geom AS geography), CAST(:point AS geography)) ASC LIMIT 1", nativeQuery = true)
    Optional<Road> findNearestRoad(@Param("point") Point point, @Param("distanceMeters") double distanceMeters);
}
