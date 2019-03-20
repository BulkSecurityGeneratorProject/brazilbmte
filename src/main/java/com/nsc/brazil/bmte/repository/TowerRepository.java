package com.nsc.brazil.bmte.repository;

import com.nsc.brazil.bmte.domain.Tower;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Tower entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TowerRepository extends JpaRepository<Tower, Long> {

}
