package com.hcl.fxg.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
//@Setter
@Builder
//@NoArgsConstructor
//@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class FxgFacility {
	private int facilityId;
	private String facilityCode;
	private int facilityType;
	private FxgFacilityAddress facilityAddress;
	private FxgFacility parentHub; 
	private FxgFacilitySchedule facilitySchedule;
	
}
