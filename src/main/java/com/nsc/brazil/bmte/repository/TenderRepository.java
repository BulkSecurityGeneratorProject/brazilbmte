package com.nsc.brazil.bmte.repository;

import com.nsc.brazil.bmte.domain.Tender;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Tender entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TenderRepository extends JpaRepository<Tender, Long> {

}
