package TicketBooking.demo.Service.Operator;


import TicketBooking.demo.Dtos.TripDtos.TripRequestDtos;
import TicketBooking.demo.Dtos.TripDtos.TripResponseDTOS;
import TicketBooking.demo.Entity.Operator.Bus;
import TicketBooking.demo.Entity.Operator.Route;
import TicketBooking.demo.Entity.Operator.Trip;
import TicketBooking.demo.Repository.Operator.BusRepository;
import TicketBooking.demo.Repository.Operator.RouteRepository;
import TicketBooking.demo.Repository.Operator.TripRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddTripService {

    private final TripRepository tripRepository;
    private final BusRepository busRepository;
    private final RouteRepository routeRepository;


    public AddTripService(TripRepository tripRepository, BusRepository busRepository, RouteRepository routeRepository) {
        this.tripRepository = tripRepository;
        this.busRepository = busRepository;
        this.routeRepository = routeRepository;
    }

    public TripResponseDTOS addTrip(TripRequestDtos tripRequestDtos){

        Bus bus= busRepository.findById(tripRequestDtos.getBusId()).orElseThrow(()-> new RuntimeException("Didnot find this BusId"));
        Route route=routeRepository.findById(tripRequestDtos.getRouteId()).orElseThrow(()-> new RuntimeException("Didnot find this route id"));

        Trip trip= new Trip();
        trip.setDepartureTime(tripRequestDtos.getDepartureTime());
        trip.setArrivalTime(tripRequestDtos.getArrivalTime());
        trip.setPrice(tripRequestDtos.getPrice());
        trip.setAvailableSeats(tripRequestDtos.getAvailableSeats());
        trip.setBus(bus);
        trip.setRoute(route);

        tripRepository.save(trip);
        TripResponseDTOS tripResponseDTOS= new TripResponseDTOS();
        tripResponseDTOS.setDepartureTime(trip.getDepartureTime());
        tripResponseDTOS.setArrivalTime(trip.getArrivalTime());
        tripResponseDTOS.setPrice(trip.getPrice());
        tripResponseDTOS.setAvailableSeats(tripRequestDtos.getAvailableSeats());
return tripResponseDTOS;

    }


    public List<TripResponseDTOS> getAllTrip(){

        List<Trip> trips= tripRepository.findAll();
        List<TripResponseDTOS> tripResponseDTOS= new ArrayList<>();

        for (Trip trip:trips){
            TripResponseDTOS tripResponseDTOS1= new TripResponseDTOS();
            tripResponseDTOS1.setDepartureTime(trip.getDepartureTime());
            tripResponseDTOS1.setArrivalTime(trip.getArrivalTime());
            tripResponseDTOS1.setPrice(trip.getPrice());
            tripResponseDTOS1.setAvailableSeats(trip.getAvailableSeats());

            tripResponseDTOS.add(tripResponseDTOS1);

        }
        return tripResponseDTOS;
    }



}
