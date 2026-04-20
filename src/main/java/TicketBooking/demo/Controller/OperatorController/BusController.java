package TicketBooking.demo.Controller.OperatorController;


import TicketBooking.demo.Dtos.OperatorDtos.AddBusRequest;
import TicketBooking.demo.Dtos.OperatorDtos.AddBusResponse;
import TicketBooking.demo.Service.Operator.AddBusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
public class BusController {
    private final AddBusService addBusService;


    public BusController(AddBusService addBusService) {
        this.addBusService = addBusService;
    }
    @PostMapping("/add")
    public ResponseEntity<AddBusResponse> addBusList(@RequestBody  AddBusRequest addBusRequest){

        return new ResponseEntity<>(addBusService.BusRequest(addBusRequest), HttpStatus.CREATED);
    }
    @GetMapping("/getList")
    public ResponseEntity<List<AddBusResponse>> getAllList(){

        return new ResponseEntity<List<AddBusResponse>>(addBusService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<AddBusResponse> getById(@PathVariable  Long id){
        return  new ResponseEntity<>(addBusService.getById(id),HttpStatus.FOUND);

    }


}
