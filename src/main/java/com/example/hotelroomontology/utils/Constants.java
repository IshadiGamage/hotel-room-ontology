package com.example.hotelroomontology.utils;

public class Constants {
    public static final String ONTOLOGY_FILE_NAME = "hotel_room.rdf";
    public static final String CLASS_URI = "http://www.semanticweb.org/ishadi/ontologies/2020/10/untitled-ontology-9#";
    public static final String BASE_QUERY = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
            "        PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" +
            "        PREFIX : <http://www.semanticweb.org/ishadi/ontologies/2020/10/hotel_rooms#>\n" +
            "        PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
            "        PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n";
}