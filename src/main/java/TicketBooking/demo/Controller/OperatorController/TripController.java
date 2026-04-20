package TicketBooking.demo.Controller.OperatorController;


import TicketBooking.demo.Dtos.TripDtos.TripRequestDtos;
import TicketBooking.demo.Dtos.TripDtos.TripResponseDTOS;
import TicketBooking.demo.Service.Operator.AddTripService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {

    private final AddTripService addTripService;

    public TripController(AddTripService addTripService) {
        this.addTripService = addTripService;
    }

    @PostMapping("/add")
    public ResponseEntity<TripResponseDTOS> addTrip(@RequestBody TripRequestDtos tripRequestDtos){
        return  new ResponseEntity<>(addTripService.addTrip(tripRequestDtos), HttpStatus.CREATED);
    }

    @GetMapping("/getTrip")
    public ResponseEntity<List<TripResponseDTOS>> getTrip(){
        return new ResponseEntity<>(addTripService.getAllTrip(),HttpStatus.OK);

    }
}
