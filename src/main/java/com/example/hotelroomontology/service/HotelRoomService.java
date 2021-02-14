package com.example.hotelroomontology.service;

import org.json.simple.JSONObject;

import java.util.List;

public interface HotelRoomService {

    List<JSONObject> getRooms(String room);
    List<JSONObject> getRoomsByPrice(int price);
    List<JSONObject> getRoomsByRoomCapacity(int capacity);
}
