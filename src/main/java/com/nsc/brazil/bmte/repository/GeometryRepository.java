package com.nsc.brazil.bmte.repository;

import com.nsc.brazil.bmte.domain.Geometry;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Geometry entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GeometryRepository extends JpaRepository<Geometry, Long> {

}
