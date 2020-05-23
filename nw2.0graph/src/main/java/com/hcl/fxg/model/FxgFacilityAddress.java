package com.hcl.fxg.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@NoArgsConstructor
//@AllArgsConstructor
@Getter
//@Setter
@ToString
@EqualsAndHashCode
@Builder
public class FxgFacilityAddress {
	private String addressLine1;
	private String addressLine2;
	private String zipCode5;
	private String zipCode4;
	private String cityName;
	private String stateCode;	
}
