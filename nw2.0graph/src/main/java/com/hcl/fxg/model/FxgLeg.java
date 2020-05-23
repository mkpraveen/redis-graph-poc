package com.hcl.fxg.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class FxgLeg {
	private FxgFacility originFacility;
	private FxgFacility destinationFacility;
	
	private int originDowId;
	private int destinationDowId;
	private int destinationSplitTypeId;
	

	
}
