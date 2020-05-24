package com.hcl.fxg.model.graph;

import com.hcl.fxg.model.entity.FxgLeg;
import com.redislabs.redisgraph.graph_entities.Edge;

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
	
	public FxgEdge(Edge redisEdge) {
		super();
		this.originDowId = Integer.parseInt(redisEdge.getProperty("originDowId").getValue().toString());
		this.destinationDowId = Integer.parseInt(redisEdge.getProperty("destinationDowId").getValue().toString());
		this.destinationSplitTypeId = Integer.parseInt(redisEdge.getProperty("destinationSplitTypeId").getValue().toString());;
	}
	
}
