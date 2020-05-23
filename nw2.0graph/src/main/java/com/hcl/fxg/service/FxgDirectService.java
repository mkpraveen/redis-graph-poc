package com.hcl.fxg.service;

import com.hcl.fxg.model.FxgLeg;
import com.hcl.fxg.model.FxgFacility;

public interface FxgDirectService {
	public FxgLeg createDirect(FxgFacility origFacility, FxgFacility destFacility, int originDowId); 
}
