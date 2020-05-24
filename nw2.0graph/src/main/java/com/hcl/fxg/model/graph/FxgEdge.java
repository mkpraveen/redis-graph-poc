package com.hcl.fxg.model.graph;

import com.hcl.fxg.model.entity.FxgLeg;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
public class FxgEdge {
	
	private int originDowId;
	private int destinationDowId;
	private int destinationSplitTypeId;
	
	public FxgEdge(FxgLeg fxgDirectLane) {
		super();
		this.originDowId = fxgDirectLane.getOriginDowId();
		this.destinationDowId = fxgDirectLane.getDestinationDowId();
		this.destinationSplitTypeId = fxgDirectLane.getDestinationSplitTypeId();
	}
	
	public FxgEdge() {
		super();
	}
	
}
