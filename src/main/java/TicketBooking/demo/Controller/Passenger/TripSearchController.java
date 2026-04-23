package TicketBooking.demo.Controller.Passenger;


import TicketBooking.demo.Dtos.PassengerDtos.TripSearchResponse;
import TicketBooking.demo.Enums.Route.Location;
import TicketBooking.demo.Service.Passenger.PassengerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/searchtrip")
public class TripSearchController {

    private final PassengerService passengerService;

    public TripSearchController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }
    @GetMapping("/gettrip")
    public ResponseEntity<List<TripSearchResponse>> getAllTripList(@RequestParam Location from, @RequestParam  Location to){
        return  new ResponseEntity<>(passengerService.getTripList(from, to), HttpStatus.OK);


    }
}
