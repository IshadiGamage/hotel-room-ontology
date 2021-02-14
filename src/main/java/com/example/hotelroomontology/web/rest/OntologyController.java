package com.example.hotelroomontology.web.rest;

import com.example.hotelroomontology.service.HotelRoomService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OntologyController {

    private final HotelRoomService hotelRoomService;

    @Autowired
    public OntologyController(HotelRoomService hotelRoomService) {
        super();
        this.hotelRoomService = hotelRoomService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JSONObject> getRooms(@RequestParam(value = "room") String room) {
        return hotelRoomService.getRooms(room);
    }

    @RequestMapping(value = "/room", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JSONObject> getRoomsByPrice(@RequestParam("price") int price) {
        return hotelRoomService.getRoomsByPrice(price);
    }

    @RequestMapping(value = "/roomCapacity", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JSONObject> getRoomsByRoomCapacity(@RequestParam("capacity") int capacity) {
        return hotelRoomService.getRoomsByRoomCapacity(capacity);
    }
}
