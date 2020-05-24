package com.hcl.fxg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.fxg.model.entity.FxgFacility;
import com.hcl.fxg.model.entity.FxgFacilityAddress;
import com.hcl.fxg.model.entity.FxgLeg;
import com.hcl.fxg.service.FxgLegService;

@RestController
public class FxgNetworkController {

	@Autowired
	private FxgLegService fxgLegServiceImpl;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/seedData")
	public ResponseEntity<String> seedData() {
		
        // Setting Facilities for path : 3411 -> 441 -> 432 -> 89 -> 3118
        //-------------------------------------------------------
        FxgFacility fxg432 = FxgFacility.builder()
        		.facilityId(432).facilityCode("COLO")
        		.facilityType(2)
        		.facilityAddress(FxgFacilityAddress.builder()
        					.addressLine1("COLUMBUS")
        					.addressLine2("HUB")
        					.cityName("COLUMBUS")
        					.stateCode("OH")
        					.zipCode5("43004")
        					.build())
        		.build();
        
        FxgFacility fxg411 = FxgFacility.builder()
        		.facilityId(411).facilityCode("ASHL")
        		.facilityType(1)
        		.facilityAddress(FxgFacilityAddress.builder()
        					.addressLine1("ASHLAND")
        					.addressLine2("GND")
        					.cityName("ASHLAND")
        					.stateCode("KY")
        					.zipCode5("41101")
        					.build())
        		.parentHub(fxg432)
        		.build();
        
        FxgFacility fxg3411 = FxgFacility.builder()
        		.facilityId(3411).facilityCode("QASH")
        		.facilityType(1)
        		.facilityAddress(FxgFacilityAddress.builder()
        					.addressLine1("ASHLAND")
        					.addressLine2("HD")
        					.cityName("ASHLAND")
        					.stateCode("KY")
        					.zipCode5("41101")
        					.build())
        		.parentHub(fxg432)
        		.build();
       
        FxgFacility fxg89 = FxgFacility.builder()
        		.facilityId(89).facilityCode("WOOD")
        		.facilityType(2)
        		.facilityAddress(FxgFacilityAddress.builder()
        					.addressLine1("WOODBRIDGE")
        					.addressLine2("HUB")
        					.cityName("WOODBRIDGE")
        					.stateCode("NJ")
        					.zipCode5("07001")
        					.build())
        		.build();
       
        FxgFacility fxg3118 = FxgFacility.builder()
        		.facilityId(3118).facilityCode("QLNI")
        		.facilityType(1)
        		.facilityAddress(FxgFacilityAddress.builder()
        					.addressLine1("LONG_ISLAND")
        					.addressLine2("HD")
        					.cityName("LONG ISLAND")
        					.stateCode("NY")
        					.zipCode5("11101")
        					.build())
        		.parentHub(fxg89)
        		.build();
        
        // Setting Legs : 3411 -> 411 -> 432 -> 89 -> 3118
        //-------------------------------------------------------
        FxgLeg fxg3411to411 = FxgLeg.builder()
        		.originFacility(fxg3411)
        		.destinationFacility(fxg411)
        		.originDowId(1)
        		.destinationDowId(1)
        		.destinationSplitTypeId(3)
        		.build();
        
        fxgLegServiceImpl.createLeg(fxg3411to411);
        
        FxgLeg fxg411to432 = FxgLeg.builder()
        		.originFacility(fxg411)
        		.destinationFacility(fxg432)
        		.originDowId(1)
        		.destinationDowId(2)
        		.destinationSplitTypeId(3)
        		.build();

        fxgLegServiceImpl.createLeg(fxg411to432);
        
        FxgLeg fxg432to89 = FxgLeg.builder()
        		.originFacility(fxg432)
        		.destinationFacility(fxg89)
        		.originDowId(2)
        		.destinationDowId(4)
        		.destinationSplitTypeId(3)
        		.build();
        
        fxgLegServiceImpl.createLeg(fxg432to89);
        
        FxgLeg fxg89to3118 = FxgLeg.builder()
        		.originFacility(fxg89)
        		.destinationFacility(fxg3118)
        		.originDowId(4)
        		.destinationDowId(4)
        		.destinationSplitTypeId(3)
        		.build();
        fxgLegServiceImpl.createLeg(fxg89to3118);
        
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	
}
