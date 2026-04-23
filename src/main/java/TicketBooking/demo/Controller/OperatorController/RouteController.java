package TicketBooking.demo.Controller.OperatorController;


import TicketBooking.demo.Dtos.RouteDtos.RouteRequestDto;
import TicketBooking.demo.Dtos.RouteDtos.RouteResponseDTO;
import TicketBooking.demo.Service.Operator.AddRouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/route")
public class RouteController {

    private final AddRouteService addRouteService;

    public RouteController(AddRouteService addRouteService) {
        this.addRouteService = addRouteService;
    }

    @PostMapping("/routeReq")
    public ResponseEntity<?> addRoutes(@RequestBody RouteRequestDto routeRequestDto){
        return new ResponseEntity<>(addRouteService.addRoute(routeRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/getRouteList")
    public ResponseEntity<List<RouteResponseDTO>> getRouteList(){
        return new ResponseEntity<>(addRouteService.getallRouteList(),HttpStatus.OK);
    }

}
