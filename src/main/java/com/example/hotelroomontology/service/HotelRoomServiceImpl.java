package com.example.hotelroomontology.service;

import com.example.hotelroomontology.utils.Constants;
import org.apache.jena.ontology.*;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.ModelFactory;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class HotelRoomServiceImpl implements HotelRoomService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HotelRoomServiceImpl.class);

    @Autowired
    public HotelRoomServiceImpl() {
        super();
    }

    @Override
    public List<JSONObject> getRooms(String room) {
        List<JSONObject> list = new ArrayList();
        try {
            OntModel model = getModel(Constants.ONTOLOGY_FILE_NAME);
            Query query = QueryFactory.create(chooseRoomType(room));
            QueryExecution qe = QueryExecutionFactory.create(query, model);
            ResultSet resultSet = qe.execSelect();
            int x = 0;
            while (resultSet.hasNext()) {
                x++;
                JSONObject obj = new JSONObject();
                QuerySolution solution = resultSet.nextSolution();
                System.out.println(solution.get(room).toString());
                obj.put("Price", solution.get("Price").toString());
                obj.put("RoomId", solution.get("RoomId").toString());
                obj.put("Beds", solution.get("Beds").toString());
                obj.put("FloorArea", solution.get("FloorArea").toString());
                obj.put("Capacity", solution.get("Capacity").toString());
                obj.put("Floor", solution.get("Floor").toString());
                list.add(obj);
            }
            System.out.println(x);
            return list;
        } catch (Exception e) {
            LOGGER.error("Error while running the query");
        }
        return null;
    }

    private String chooseRoomType(String room) {
        if (room.equals("Single")) {
            return Constants.BASE_QUERY +
                    "        SELECT ?Single ?Price ?RoomId ?Beds ?FloorArea ?Capacity ?Floor\n" +
                    "                WHERE { \n" +
                    "                    ?Single rdf:type :Single.\n" +
                    "                    ?Single :hasRoomId ?RoomId.\n" +
                    "                    ?Single :hasPriceValue ?Price.\n" +
                    "                    ?Single :hasNoOfBeds ?Beds.\n" +
                    "                    ?Single :hasFloorAreaValue ?FloorArea.\n" +
                    "                    ?Single :hasRoomCapacityValue ?Capacity.\n" +
                    "                    ?Single :hasFloorNoValue ?Floor.\n" +
                    "                }";
        } if (room.equals("Double")) {
            return Constants.BASE_QUERY +
                    "        SELECT ?Double ?Price ?RoomId ?Beds ?FloorArea ?Capacity ?Floor\n" +
                    "                WHERE { \n" +
                    "                    ?Double rdf:type :Double.\n" +
                    "                    ?Double :hasRoomId ?RoomId.\n" +
                    "                    ?Double :hasPriceValue ?Price.\n" +
                    "                    ?Double :hasNoOfBeds ?Beds.\n" +
                    "                    ?Double :hasFloorAreaValue ?FloorArea.\n" +
                    "                    ?Double :hasRoomCapacityValue ?Capacity.\n" +
                    "                    ?Double :hasFloorNoValue ?Floor.\n" +
                    "                }";
        } if (room.equals("Queen")) {
            return Constants.BASE_QUERY +
                    "        SELECT ?Queen ?Price ?RoomId ?Beds ?FloorArea ?Capacity ?Floor\n" +
                    "                WHERE { \n" +
                    "                    ?Queen rdf:type :Double.\n" +
                    "                    ?Queen :hasRoomId ?RoomId.\n" +
                    "                    ?Queen :hasPriceValue ?Price.\n" +
                    "                    ?Queen :hasNoOfBeds ?Beds.\n" +
                    "                    ?Queen :hasFloorAreaValue ?FloorArea.\n" +
                    "                    ?Queen :hasRoomCapacityValue ?Capacity.\n" +
                    "                    ?Queen :hasFloorNoValue ?Floor.\n" +
                    "                }";
        } if (room.equals("King")) {
            return Constants.BASE_QUERY +
                    "        SELECT ?King ?Price ?RoomId ?Beds ?FloorArea ?Capacity ?Floor\n" +
                    "                WHERE { \n" +
                    "                    ?King rdf:type :Double.\n" +
                    "                    ?King :hasRoomId ?RoomId.\n" +
                    "                    ?King :hasPriceValue ?Price.\n" +
                    "                    ?King :hasNoOfBeds ?Beds.\n" +
                    "                    ?King :hasFloorAreaValue ?FloorArea.\n" +
                    "                    ?King :hasRoomCapacityValue ?Capacity.\n" +
                    "                    ?King :hasFloorNoValue ?Floor.\n" +
                    "                }";
        } if (room.equals("HollywoodTwinRoom")) {
            return Constants.BASE_QUERY +
                    "        SELECT ?HollywoodTwinRoom ?Price ?RoomId ?Beds ?FloorArea ?Capacity ?Floor\n" +
                    "                WHERE { \n" +
                    "                    ?HollywoodTwinRoom rdf:type :Double.\n" +
                    "                    ?HollywoodTwinRoom :hasRoomId ?RoomId.\n" +
                    "                    ?HollywoodTwinRoom :hasPriceValue ?Price.\n" +
                    "                    ?HollywoodTwinRoom :hasNoOfBeds ?Beds.\n" +
                    "                    ?HollywoodTwinRoom :hasFloorAreaValue ?FloorArea.\n" +
                    "                    ?HollywoodTwinRoom :hasRoomCapacityValue ?Capacity.\n" +
                    "                    ?HollywoodTwinRoom :hasFloorNoValue ?Floor.\n" +
                    "                }";
        } if (room.equals("Quad")) {
            return Constants.BASE_QUERY +
                    "        SELECT ?Quad ?Price ?RoomId ?Beds ?FloorArea ?Capacity ?Floor\n" +
                    "                WHERE { \n" +
                    "                    ?Quad rdf:type :Double.\n" +
                    "                    ?Quad :hasRoomId ?RoomId.\n" +
                    "                    ?Quad :hasPriceValue ?Price.\n" +
                    "                    ?Quad :hasNoOfBeds ?Beds.\n" +
                    "                    ?Quad :hasFloorAreaValue ?FloorArea.\n" +
                    "                    ?Quad :hasRoomCapacityValue ?Capacity.\n" +
                    "                    ?Quad :hasFloorNoValue ?Floor.\n" +
                    "                }";
        } if (room.equals("Suite")) {
            return Constants.BASE_QUERY +
                    "        SELECT ?Suite ?Price ?RoomId ?Beds ?FloorArea ?Capacity ?Floor\n" +
                    "                WHERE { \n" +
                    "                    ?Suite rdf:type :Double.\n" +
                    "                    ?Suite :hasRoomId ?RoomId.\n" +
                    "                    ?Suite :hasPriceValue ?Price.\n" +
                    "                    ?Suite :hasNoOfBeds ?Beds.\n" +
                    "                    ?Suite :hasFloorAreaValue ?FloorArea.\n" +
                    "                    ?Suite :hasRoomCapacityValue ?Capacity.\n" +
                    "                    ?Suite :hasFloorNoValue ?Floor.\n" +
                    "                }";
        } if (room.equals("TrippleRoom")) {
            return Constants.BASE_QUERY +
                    "        SELECT ?Cabana ?Price ?RoomId ?Beds ?FloorArea ?Capacity ?Floor\n" +
                    "                WHERE { \n" +
                    "                    ?TrippleRoom rdf:type :Double.\n" +
                    "                    ?TrippleRoom :hasRoomId ?RoomId.\n" +
                    "                    ?TrippleRoom :hasPriceValue ?Price.\n" +
                    "                    ?TrippleRoom :hasNoOfBeds ?Beds.\n" +
                    "                    ?TrippleRoom :hasFloorAreaValue ?FloorArea.\n" +
                    "                    ?TrippleRoom :hasRoomCapacityValue ?Capacity.\n" +
                    "                    ?TrippleRoom :hasFloorNoValue ?Floor.\n" +
                    "                }";
        } if (room.equals("TwinDoubleRoom")) {
            return Constants.BASE_QUERY +
                    "        SELECT ?TwinDoubleRoom ?Price ?RoomId ?Beds ?FloorArea ?Capacity ?Floor\n" +
                    "                WHERE { \n" +
                    "                    ?TwinDoubleRoom rdf:type :Double.\n" +
                    "                    ?TwinDoubleRoom :hasRoomId ?RoomId.\n" +
                    "                    ?TwinDoubleRoom :hasPriceValue ?Price.\n" +
                    "                    ?TwinDoubleRoom :hasNoOfBeds ?Beds.\n" +
                    "                    ?TwinDoubleRoom :hasFloorAreaValue ?FloorArea.\n" +
                    "                    ?TwinDoubleRoom :hasRoomCapacityValue ?Capacity.\n" +
                    "                    ?TwinDoubleRoom :hasFloorNoValue ?Floor.\n" +
                    "                }";
        } if (room.equals("TwinRoom")) {
            return Constants.BASE_QUERY +
                    "        SELECT ?TwinRoom ?Price ?RoomId ?Beds ?FloorArea ?Capacity ?Floor\n" +
                    "                WHERE { \n" +
                    "                    ?TwinRoom rdf:type :Double.\n" +
                    "                    ?TwinRoom :hasRoomId ?RoomId.\n" +
                    "                    ?TwinRoom :hasPriceValue ?Price.\n" +
                    "                    ?TwinRoom :hasNoOfBeds ?Beds.\n" +
                    "                    ?TwinRoom :hasFloorAreaValue ?FloorArea.\n" +
                    "                    ?TwinRoom :hasRoomCapacityValue ?Capacity.\n" +
                    "                    ?TwinRoom :hasFloorNoValue ?Floor.\n" +
                    "                }";
        }
        return null;
    }

    @Override
    public List<JSONObject> getRoomsByPrice(int price) {
        List<JSONObject> list=new ArrayList();
        try {
            OntModel model = getModel(Constants.ONTOLOGY_FILE_NAME);

            String sprql =  Constants.BASE_QUERY + "SELECT ?HotelRooms ?Price ?RoomId ?Beds ?FloorArea ?Capacity ?Floor\n" +
                    "                WHERE { \n" +
                    "                    ?HotelRooms rdf:type owl:NamedIndividual.\n" +
                    "                    ?HotelRooms :hasPriceValue ?Price.\n" +
                    "                    ?HotelRooms :hasRoomId ?RoomId.\n" +
                    "                    ?HotelRooms :hasPriceValue ?Price.\n" +
                    "                    ?HotelRooms :hasNoOfBeds ?Beds.\n" +
                    "                    ?HotelRooms :hasFloorAreaValue ?FloorArea.\n" +
                    "                    ?HotelRooms :hasRoomCapacityValue ?Capacity.\n" +
                    "                    ?HotelRooms :hasFloorNoValue ?Floor.\n" +
                    "                }";
            Query query = QueryFactory.create(sprql);
            QueryExecution qe = QueryExecutionFactory.create(query, model);
            ResultSet resultSet = qe.execSelect();
            int x=0;
            while (resultSet.hasNext()) {
                x++;
                JSONObject obj = new JSONObject();
                QuerySolution solution = resultSet.nextSolution();
                System.out.println(solution.get("HotelRooms").toString());
                System.out.println("solution");

                String data = solution.get("Price").toString().split("h")[0];
                System.out.println(data);
                data = data.replaceAll("[^\\d.]", "");
                int priceValue =Integer.parseInt(data);

                System.out.println(Integer.parseInt(data));
                if (priceValue>=price){
                    System.out.print("success");
                    obj.put("Price", solution.get("Price").toString());
                    obj.put("RoomId", solution.get("RoomId").toString());
                    obj.put("Beds", solution.get("Beds").toString());
                    obj.put("FloorArea", solution.get("FloorArea").toString());
                    obj.put("Capacity", solution.get("Capacity").toString());
                    obj.put("Floor", solution.get("Floor").toString());
                }
                System.out.println(x);
                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            LOGGER.error("Error while running the query");
        }
        return null;
    }

    @Override
    public List<JSONObject> getRoomsByRoomCapacity(int capacity) {
        List<JSONObject> list=new ArrayList();
        try {
            OntModel model = getModel(Constants.ONTOLOGY_FILE_NAME);

            String sprql =  Constants.BASE_QUERY + "SELECT ?HotelRooms ?Price ?RoomId ?Beds ?FloorArea ?Capacity ?Floor\n" +
                    "                WHERE { \n" +
                    "                    ?HotelRooms rdf:type owl:NamedIndividual.\n" +
                    "                    ?HotelRooms :hasPriceValue ?Price.\n" +
                    "                    ?HotelRooms :hasRoomId ?RoomId.\n" +
                    "                    ?HotelRooms :hasPriceValue ?Price.\n" +
                    "                    ?HotelRooms :hasNoOfBeds ?Beds.\n" +
                    "                    ?HotelRooms :hasFloorAreaValue ?FloorArea.\n" +
                    "                    ?HotelRooms :hasRoomCapacityValue ?Capacity.\n" +
                    "                    ?HotelRooms :hasFloorNoValue ?Floor.\n" +
                    "                }";
            Query query = QueryFactory.create(sprql);
            QueryExecution qe = QueryExecutionFactory.create(query, model);
            ResultSet resultSet = qe.execSelect();
            int x=0;
            while (resultSet.hasNext()) {
                x++;
                JSONObject obj = new JSONObject();
                QuerySolution solution = resultSet.nextSolution();
                System.out.println(solution.get("HotelRooms").toString());
                System.out.println("solution");

                String data = solution.get("Capacity").toString().split("h")[0];
                System.out.println(data);
                data = data.replaceAll("[^\\d.]", "");
                int priceValue =Integer.parseInt(data);

                System.out.println(Integer.parseInt(data));
                if (priceValue>=capacity){
                    obj.put("Price", solution.get("Price").toString());
                    obj.put("RoomId", solution.get("RoomId").toString());
                    obj.put("Beds", solution.get("Beds").toString());
                    obj.put("FloorArea", solution.get("FloorArea").toString());
                    obj.put("Capacity", solution.get("Capacity").toString());
                    obj.put("Floor", solution.get("Floor").toString());
                }
                System.out.println(x);
                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            LOGGER.error("Error while running the query");
        }
        return null;
    }

    private OntModel getModel(String fileName) throws FileNotFoundException {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        model.read(new FileReader(new File(fileName)), null);
        return model;
    }
}
