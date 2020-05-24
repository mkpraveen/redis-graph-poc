package com.hcl.fxg.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.fxg.model.entity.FxgFacility;

@Repository
public interface FxgFacilityRepository extends JpaRepository<FxgFacility, Long> {

}
