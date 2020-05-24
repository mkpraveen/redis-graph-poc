package com.hcl.fxg;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.fxg.model.entity.FxgFacility;
import com.hcl.fxg.model.entity.FxgFacilityAddress;
import com.hcl.fxg.model.entity.FxgLeg;
import com.hcl.fxg.model.graph.FxgEdge;
import com.hcl.fxg.model.graph.FxgNode;
import com.redislabs.redisgraph.Record;
import com.redislabs.redisgraph.ResultSet;
import com.redislabs.redisgraph.graph_entities.Edge;
import com.redislabs.redisgraph.graph_entities.Node;
import com.redislabs.redisgraph.impl.api.RedisGraph;

public class RedisGraphExample {
    public static void main(String[] args) {
    	     
        
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
        
        FxgLeg fxg411to432 = FxgLeg.builder()
        		.originFacility(fxg411)
        		.destinationFacility(fxg432)
        		.originDowId(1)
        		.destinationDowId(2)
        		.destinationSplitTypeId(3)
        		.build();

        FxgLeg fxg432to89 = FxgLeg.builder()
        		.originFacility(fxg432)
        		.destinationFacility(fxg89)
        		.originDowId(2)
        		.destinationDowId(4)
        		.destinationSplitTypeId(3)
        		.build();
        
        FxgLeg fxg89to3118 = FxgLeg.builder()
        		.originFacility(fxg89)
        		.destinationFacility(fxg3118)
        		.originDowId(4)
        		.destinationDowId(4)
        		.destinationSplitTypeId(3)
        		.build();
        
        
        // general context api. Not bound to graph key or connection
        RedisGraph graph = new RedisGraph("127.0.0.1",6379);
        
        System.out.println("Create Graph Query : " + createDirectGraphQuery(fxg3411to411));

        final String FXG_NW_GRAPH_NAME = "FXG_NETWORK";
        graph.deleteGraph(FXG_NW_GRAPH_NAME);
        
        graph.query(FXG_NW_GRAPH_NAME, createDirectGraphQuery(fxg3411to411));
        graph.query(FXG_NW_GRAPH_NAME, createDirectGraphQuery(fxg411to432));
        graph.query(FXG_NW_GRAPH_NAME, createDirectGraphQuery(fxg432to89));
        graph.query(FXG_NW_GRAPH_NAME, createDirectGraphQuery(fxg89to3118));
        
        		
        ResultSet resultSet = graph.query(FXG_NW_GRAPH_NAME, "MATCH (n:FxgNode)-[e:FxgEdge]->(n1:FxgNode {facilityId:411}) RETURN n,e");
        while(resultSet.hasNext()) {
            Record record = resultSet.next();
            // get values
            Node n = record.getValue("n");
            Edge e =  record.getValue("e");
                        
            //print record
            System.out.println("Result : " + record.toString());
        }

    }
    
    public static String createDirectGraphQuery(FxgLeg fxgLeg) {
    	String retQuery = "";
    	FxgNode originNode = new FxgNode(fxgLeg.getOriginFacility());
    	FxgNode destinationNode = new FxgNode(fxgLeg.getDestinationFacility());
    	FxgEdge fxgEdgeConnect = new FxgEdge(fxgLeg);
    	
    	ObjectMapper mapper = new ObjectMapper();
    	mapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, false);
    	mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		try {		
			retQuery = "CREATE (:FxgNode" + mapper.writer().writeValueAsString(originNode) + ")-[:FxgEdge" + mapper.writer().writeValueAsString(fxgEdgeConnect) + "]->(:FxgNode" + mapper.writer().writeValueAsString(destinationNode) + ")";
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   	
    	return retQuery;
    }
}
