package com.hcl.fxg.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@ToString
@EqualsAndHashCode
@Builder
@Table(name = "FXG_FACILITY_ADDRESS")
public class FxgFacilityAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADDR_ID")
	private long id;
	
	@Column(name = "ADDR_LINE_1")
	private String addressLine1;
	@Column(name = "ADDR_LINE_2")
	private String addressLine2;
	@Column(name = "ZIP_CODE_5")
	private String zipCode5;
	@Column(name = "ZIP_CODE_4")
	private String zipCode4;
	@Column(name = "CITY_NAME")
	private String cityName;
	@Column(name = "STATE_CODE")
	private String stateCode;	
}
