package com.hcl.fxg.service;

import com.hcl.fxg.model.FxgDirectLanes;
import com.hcl.fxg.model.FxgFacility;

public interface FxgDirectService {
	public FxgDirectLanes createDirect(FxgFacility origFacility, FxgFacility destFacility, int originDowId); 
}
