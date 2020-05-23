package com.hcl.fxg.model;

import java.util.Arrays;

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
public class FxgFacilitySchedule {

//	public static final Integer HOURS_8AM_TO_5PM = 1;
//	public static final Integer HOURS_11AM_TO_8PM = 2;
//	public static final Integer HOURS_2PM_TO_11PM = 2;
//	public static final Integer HOURS_00AM_TO_11PM = 3;
	
	private Boolean[] daysOfWeek = new Boolean[7];
	private Integer[] workingHours = new Integer[7];
		
}
