package com.hcl.fxg.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.fxg.model.entity.FxgFacility;
import com.hcl.fxg.model.repository.FxgFacilityRepository;

public class FxgFacilityServiceImpl implements FxgFacilityService {

	@Autowired
	private FxgFacilityRepository fxgFacilityRepo;
	
	@Override
	public FxgFacility saveFacility(FxgFacility fxgFacility) {
		return fxgFacilityRepo.save(fxgFacility);
	}
}
