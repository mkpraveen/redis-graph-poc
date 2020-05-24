package com.hcl.fxg.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.hcl.fxg.util.RedisGraphUtil;
import com.redislabs.redisgraph.impl.api.RedisGraph;

@RestController
public class FxgDataController {

	@Autowired
	private FxgLegService fxgLegServiceImpl;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/seedDatabase")
	public ResponseEntity<String> seedData() {
		
        // Setting Facilities for example paths 
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
        
        FxgFacility fxg3258 = FxgFacility.builder()
        		.facilityId(3258).facilityCode("QBEC")
        		.facilityType(1)
        		.facilityAddress(FxgFacilityAddress.builder()
        					.addressLine1("BECKLEY")
        					.addressLine2("HD")
        					.cityName("BECKLEY")
        					.stateCode("WV")
        					.zipCode5("25801")
        					.build())
        		.parentHub(fxg432)
        		.build();
        
        FxgFacility fxg258 = FxgFacility.builder()
        		.facilityId(258).facilityCode("BECK")
        		.facilityType(1)
        		.facilityAddress(FxgFacilityAddress.builder()
        					.addressLine1("BECKLEY")
        					.addressLine2("GND")
        					.cityName("BECKLEY")
        					.stateCode("WV")
        					.zipCode5("25801")
        					.build())
        		.parentHub(fxg432)
        		.build();
        
        FxgFacility fxg3106 = FxgFacility.builder()
        		.facilityId(3106).facilityCode("QBRX")
        		.facilityType(1)
        		.facilityAddress(FxgFacilityAddress.builder()
        					.addressLine1("BRONX")
        					.addressLine2("HD")
        					.cityName("BRONX")
        					.stateCode("NY")
        					.zipCode5("10453")
        					.build())
        		.parentHub(fxg89)
        		.build();
        
        
        FxgFacility fxg62 = FxgFacility.builder()
        		.facilityId(62).facilityCode("MIDD")
        		.facilityType(2)
        		.facilityAddress(FxgFacilityAddress.builder()
        					.addressLine1("MIDDLETOWN")
        					.addressLine2("HUB")
        					.cityName("MIDDLETOWN")
        					.stateCode("CT")
        					.zipCode5("06023")
        					.build())
        		.build();
        
        FxgFacility fxg16 = FxgFacility.builder()
        		.facilityId(16).facilityCode("WORC")
        		.facilityType(1)
        		.facilityAddress(FxgFacilityAddress.builder()
        					.addressLine1("WORCESTER")
        					.addressLine2("GND")
        					.cityName("WORCESTER")
        					.stateCode("MA")
        					.zipCode5("01601")
        					.build())
        		.parentHub(fxg62)
        		.build();
        
        FxgFacility fxg841 = FxgFacility.builder()
        		.facilityId(841).facilityCode("SALT")
        		.facilityType(2)
        		.facilityAddress(FxgFacilityAddress.builder()
        					.addressLine1("SALT LAKE CITY")
        					.addressLine2("HUB")
        					.cityName("SALT LAKE CITY")
        					.stateCode("UT")
        					.zipCode5("84044")
        					.build())
        		.build();
        
        FxgFacility fxg837 = FxgFacility.builder()
        		.facilityId(837).facilityCode("BOIS")
        		.facilityType(1)
        		.facilityAddress(FxgFacilityAddress.builder()
        					.addressLine1("BOISE")
        					.addressLine2("GND")
        					.cityName("BOISE")
        					.stateCode("ID")
        					.zipCode5("83701")
        					.build())
        		.parentHub(fxg841)
        		.build();
        
        FxgFacility fxg3837 = FxgFacility.builder()
        		.facilityId(3837).facilityCode("QBOI")
        		.facilityType(1)
        		.facilityAddress(FxgFacilityAddress.builder()
        					.addressLine1("BOISE")
        					.addressLine2("HD")
        					.cityName("BOISE")
        					.stateCode("ID")
        					.zipCode5("83701")
        					.build())
        		.parentHub(fxg841)
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
        
        // Setting Legs : 3258 -> 258 -> 432 -> 89 -> 3106
        //-------------------------------------------------------
        FxgLeg fxg3258to258 = FxgLeg.builder()
        		.originFacility(fxg3258)
        		.destinationFacility(fxg258)
        		.originDowId(1)
        		.destinationDowId(1)
        		.destinationSplitTypeId(3)
        		.build();
        
        fxgLegServiceImpl.createLeg(fxg3258to258);
        
        FxgLeg fxg258to432 = FxgLeg.builder()
        		.originFacility(fxg258)
        		.destinationFacility(fxg432)
        		.originDowId(1)
        		.destinationDowId(2)
        		.destinationSplitTypeId(3)
        		.build();

        fxgLegServiceImpl.createLeg(fxg258to432);
        
        FxgLeg fxg89to3106 = FxgLeg.builder()
        		.originFacility(fxg89)
        		.destinationFacility(fxg3106)
        		.originDowId(4)
        		.destinationDowId(4)
        		.destinationSplitTypeId(3)
        		.build();

        fxgLegServiceImpl.createLeg(fxg89to3106);

        // Setting Legs : 3106 -> 16 -> 62 -> 432 -> 258 -> 3258
        //------------------------------------------------------
        FxgLeg fxg3106to16 = FxgLeg.builder()
        		.originFacility(fxg3106)
        		.destinationFacility(fxg16)
        		.originDowId(1)
        		.destinationDowId(1)
        		.destinationSplitTypeId(3)
        		.build();
        fxgLegServiceImpl.createLeg(fxg3106to16);
        
        FxgLeg fxg16to62 = FxgLeg.builder()
        		.originFacility(fxg16)
        		.destinationFacility(fxg62)
        		.originDowId(1)
        		.destinationDowId(2)
        		.destinationSplitTypeId(3)
        		.build();        
        fxgLegServiceImpl.createLeg(fxg16to62);
        
        FxgLeg fxg62to432 = FxgLeg.builder()
        		.originFacility(fxg62)
        		.destinationFacility(fxg432)
        		.originDowId(2)
        		.destinationDowId(4)
        		.destinationSplitTypeId(3)
        		.build();
        fxgLegServiceImpl.createLeg(fxg62to432);
        
        FxgLeg fxg432to258 = FxgLeg.builder()
        		.originFacility(fxg432)
        		.destinationFacility(fxg258)
        		.originDowId(4)
        		.destinationDowId(5)
        		.destinationSplitTypeId(3)
        		.build();
        fxgLegServiceImpl.createLeg(fxg432to258);
        
        FxgLeg fxg258to3258 = FxgLeg.builder()
        		.originFacility(fxg258)
        		.destinationFacility(fxg3258)
        		.originDowId(5)
        		.destinationDowId(6)
        		.destinationSplitTypeId(3)
        		.build();
        fxgLegServiceImpl.createLeg(fxg258to3258);
        
        
        // Setting Legs : 3106 -> 16 -> 62 -> 841 -> 837 -> 3837
        //------------------------------------------------------
        FxgLeg fxg62to841 = FxgLeg.builder()
        		.originFacility(fxg62)
        		.destinationFacility(fxg841)
        		.originDowId(2)
        		.destinationDowId(4)
        		.destinationSplitTypeId(3)
        		.build();
        fxgLegServiceImpl.createLeg(fxg62to841);
        
        FxgLeg fxg841to837 = FxgLeg.builder()
        		.originFacility(fxg841)
        		.destinationFacility(fxg837)
        		.originDowId(4)
        		.destinationDowId(5)
        		.destinationSplitTypeId(3)
        		.build();
        fxgLegServiceImpl.createLeg(fxg841to837);
        
        FxgLeg fxg837to3837 = FxgLeg.builder()
        		.originFacility(fxg837)
        		.destinationFacility(fxg3837)
        		.originDowId(5)
        		.destinationDowId(6)
        		.destinationSplitTypeId(3)
        		.build();
        fxgLegServiceImpl.createLeg(fxg837to3837);
        
        
        // general context api. Not bound to graph key or connection
        RedisGraph graph = new RedisGraph(RedisGraphUtil.REDIS_SERVER_HOSTNAME,RedisGraphUtil.REDIS_SERVER_PORT);        
        
        
        //fxgLegServiceImpl.getAllFxgLegs().forEach( leg ->  graph.query(FXG_NW_GRAPH_NAME, RedisGraphUtil.createLegGraphQuery(leg)) );
        
        // Setting Lane : 3411 -> 411 -> 432 -> 89 -> 3118
        //-------------------------------------------------------
        List<FxgLeg> legs = new ArrayList<>();
        legs.add(fxg3411to411);
        legs.add(fxg411to432);
        legs.add(fxg432to89);
        legs.add(fxg89to3118);                
        graph.query(RedisGraphUtil.FXG_NW_GRAPH_NAME, RedisGraphUtil.createPathGraphQuery(legs));
        
        
        // Setting Legs : 3258 -> 258 -> 432 -> 89 -> 3106
        //-------------------------------------------------------
        legs = new ArrayList<>();
        legs.add(fxg3258to258);
        legs.add(fxg258to432);
        legs.add(fxg432to89);
        legs.add(fxg89to3106); 
        graph.query(RedisGraphUtil.FXG_NW_GRAPH_NAME, RedisGraphUtil.createPathGraphQuery(legs));
        
        // Setting Legs : 3106 -> 16 -> 62 -> 432 -> 258 -> 3258
        //------------------------------------------------------
        legs = new ArrayList<>();
        legs.add(fxg3106to16);
        legs.add(fxg16to62);
        legs.add(fxg62to432);
        legs.add(fxg432to258);
        legs.add(fxg258to3258); 
        graph.query(RedisGraphUtil.FXG_NW_GRAPH_NAME, RedisGraphUtil.createPathGraphQuery(legs));
        
        // Setting Legs : 3106 -> 16 -> 62 -> 841 -> 837 -> 3837
        //------------------------------------------------------
        legs = new ArrayList<>();
        legs.add(fxg3106to16);
        legs.add(fxg16to62);
        legs.add(fxg62to841);
        legs.add(fxg841to837);
        legs.add(fxg837to3837); 
        graph.query(RedisGraphUtil.FXG_NW_GRAPH_NAME, RedisGraphUtil.createPathGraphQuery(legs));
        
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/deleteGraph")
	public ResponseEntity<String> seedGraph() {
		
        // general context api. Not bound to graph key or connection
        RedisGraph graph = new RedisGraph(RedisGraphUtil.REDIS_SERVER_HOSTNAME,RedisGraphUtil.REDIS_SERVER_PORT);
        graph.deleteGraph(RedisGraphUtil.FXG_NW_GRAPH_NAME);
                		
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
}
