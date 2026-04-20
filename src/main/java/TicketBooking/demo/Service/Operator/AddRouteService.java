package TicketBooking.demo.Service.Operator;


import TicketBooking.demo.Dtos.RouteDtos.RouteRequestDto;
import TicketBooking.demo.Dtos.RouteDtos.RouteResponseDTO;
import TicketBooking.demo.Entity.Operator.Route;
import TicketBooking.demo.Repository.Operator.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddRouteService {

    private final RouteRepository routeRepository;

    public AddRouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }


    public String addRoute(RouteRequestDto routeRequestDto){

        Route route= new Route();
        route.setFrom(routeRequestDto.getFrom());
        route.setTo(routeRequestDto.getTo());
        routeRepository.save(route);

        return "Route Added Success!";
    }

    public List<RouteResponseDTO> getallRouteList(){

        List<Route> routes= routeRepository.findAll();
        List<RouteResponseDTO> routeResponseDTOS= new ArrayList<>();

        for(Route route: routes){

            RouteResponseDTO routeResponseDTO= new RouteResponseDTO();
            routeResponseDTO.setFrom(route.getFrom());
            routeResponseDTO.setTo(route.getTo());
            routeResponseDTOS.add(routeResponseDTO);
        }
        return  routeResponseDTOS;
    }


}
