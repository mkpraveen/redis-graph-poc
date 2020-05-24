package com.hcl.fxg;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hcl.fxg.model.FxgLane;
import com.hcl.fxg.model.entity.FxgFacility;
import com.hcl.fxg.model.entity.FxgFacilityAddress;
import com.hcl.fxg.model.entity.FxgLeg;
import com.hcl.fxg.model.graph.FxgEdge;
import com.hcl.fxg.model.graph.FxgNode;
import com.hcl.fxg.util.RedisGraphUtil;
import com.redislabs.redisgraph.Record;
import com.redislabs.redisgraph.ResultSet;
import com.redislabs.redisgraph.graph_entities.Edge;
import com.redislabs.redisgraph.graph_entities.Node;
import com.redislabs.redisgraph.graph_entities.Path;
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
        RedisGraph graph = new RedisGraph(RedisGraphUtil.REDIS_SERVER_HOSTNAME,RedisGraphUtil.REDIS_SERVER_PORT);
        
        System.out.println("Create Graph Query : " + RedisGraphUtil.createLegGraphQuery(fxg3411to411));
        System.out.println("Create Graph Query : " + RedisGraphUtil.createLegGraphQuery(fxg411to432));

        final String FXG_NW_GRAPH_NAME = "FXG_NETWORK";
        graph.deleteGraph(FXG_NW_GRAPH_NAME);
        
        List<FxgLeg> legs = new ArrayList<>();
        legs.add(fxg3411to411);
        legs.add(fxg411to432);
        legs.add(fxg432to89);
        legs.add(fxg89to3118);
        
//        graph.query(FXG_NW_GRAPH_NAME, RedisGraphUtil.createLegGraphQuery(fxg3411to411));
//        graph.query(FXG_NW_GRAPH_NAME, RedisGraphUtil.createLegGraphQuery(fxg411to432));
//        graph.query(FXG_NW_GRAPH_NAME, RedisGraphUtil.createLegGraphQuery(fxg432to89));
//        graph.query(FXG_NW_GRAPH_NAME, RedisGraphUtil.createLegGraphQuery(fxg89to3118));
        
        System.out.println(RedisGraphUtil.createPathGraphQuery(legs));
        
        graph.query(FXG_NW_GRAPH_NAME, RedisGraphUtil.createPathGraphQuery(legs));
        
        		
        ResultSet resultSet = graph.query(FXG_NW_GRAPH_NAME, "MATCH (n:FxgNode)-[e:FxgEdge]->(n1:FxgNode {facilityId:411}) RETURN n,e");
        while(resultSet.hasNext()) {
            Record record = resultSet.next();
            // get values
            Node n = record.getValue("n");
            Edge e =  record.getValue("e");
                        
            //print record
            System.out.println("Result : " + record.toString());
        }
        
        Map<String, Object> params = new HashMap<>();
        params.put("origId", 3411);
        params.put("destId", 3118);
        
               
        resultSet = graph.query(FXG_NW_GRAPH_NAME, "MATCH p = (:FxgNode {facilityId:$origId})-[:FxgEdge*1..10]->(:FxgNode {facilityId:$destId}) RETURN p", params);
        
        FxgLane fxgLane = new FxgLane();
        fxgLane.setSortPoints(new ArrayList<>());
        
        fxgLane.setOrigFacilityId(3411);
        fxgLane.setDestFacilityId(3118);
        
        
        while(resultSet.hasNext()) {
            Record record = resultSet.next();
            Path p = record.getValue("p");

            
            // More path API at Javadoc.
            //System.out.println(p.nodeCount());
            
            p.getNodes().forEach( n -> {
            	System.out.println( "Node : " + new FxgNode(n));
            	System.out.println( "Node : " + n);
            });
            
            p.getEdges().forEach( e -> {
            	FxgEdge fxgEdge = new FxgEdge(e);
            	
            	Node node = p.getNodes().stream().filter( t -> t.getId() == e.getSource()).findFirst().orElse(null);
            	if (null != node) {
            		FxgNode fxgNode = new FxgNode(node);
            		
            		Map<Integer, Integer> sortPoint = new HashMap<>();
            		sortPoint.put(fxgNode.getFacilityId(), fxgEdge.getOriginDowId());
            		fxgLane.getSortPoints().add(sortPoint);
            	}
            });
            
            System.out.println(fxgLane);
        }

    }
    

}
