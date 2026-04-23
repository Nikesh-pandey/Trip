package TicketBooking.demo.Controller.Passenger;

import TicketBooking.demo.Dtos.PassengerDtos.SeatDisplayDto;
import TicketBooking.demo.Entity.Operator.Trip;
import TicketBooking.demo.Service.Passenger.PassengerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/availableSeat")
public class SeatSelectController {
    private final PassengerService passengerService;

    public SeatSelectController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }
    @GetMapping("/exists/{id}")
    public ResponseEntity<SeatDisplayDto> getSeat(@PathVariable Long id){
        System.out.println("search here");
        return  new ResponseEntity<>(passengerService.getTripByID(id), HttpStatus.OK);
    }

    @PostMapping("/bookSeat/{id}")
    public ResponseEntity<String> bookSeat(
            @PathVariable Long id,
            @RequestParam Integer noofSeat) {   
        return new ResponseEntity<>(
                passengerService.bookSeat(id, noofSeat),
                HttpStatus.CREATED);
    }

}
