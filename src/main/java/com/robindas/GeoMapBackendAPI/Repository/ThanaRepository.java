package com.robindas.GeoMapBackendAPI.Repository;

import com.robindas.GeoMapBackendAPI.Models.Thana;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;

import java.util.List;
import java.util.Optional;

@Repository
public interface ThanaRepository extends JpaRepository<Thana, Integer> {

    @Query(value = "SELECT * FROM m2mdev.spatial_thana t WHERE ST_Contains(t.geom, :point) LIMIT 1", nativeQuery = true)
    Optional<Thana> findNearestThana(@Param("point") Point point);

}
