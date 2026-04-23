package TicketBooking.demo.Service.Passenger;


import TicketBooking.demo.Dtos.OperatorDtos.AddBusResponse;
import TicketBooking.demo.Dtos.PassengerDtos.SeatDisplayDto;
import TicketBooking.demo.Dtos.PassengerDtos.TripSearchResponse;
import TicketBooking.demo.Dtos.RouteDtos.RouteResponseDTO;
import TicketBooking.demo.Entity.Operator.Bus;
import TicketBooking.demo.Entity.Operator.Route;
import TicketBooking.demo.Entity.Operator.Trip;
import TicketBooking.demo.Enums.Route.Location;
import TicketBooking.demo.Repository.Operator.BusRepository;
import TicketBooking.demo.Repository.Operator.RouteRepository;
import TicketBooking.demo.Repository.Operator.TripRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerService {
    private final BusRepository busRepository;
    private final RouteRepository routeRepository;
    private final TripRepository tripRepository;

    public PassengerService(BusRepository busRepository, RouteRepository routeRepository, TripRepository tripRepository) {
        this.busRepository = busRepository;
        this.routeRepository = routeRepository;
        this.tripRepository = tripRepository;
    }



public List<TripSearchResponse> getTripList(Location from, Location to){
Route route= routeRepository.findByFromAndTo(from, to).orElseThrow(()->new RuntimeException("didnot find this route"));
List<Trip> trips=tripRepository.findByRoute(route);

List<TripSearchResponse> tripSearchResponses= new ArrayList<>();
for(Trip trip:trips){

    TripSearchResponse tripSearchResponse= new TripSearchResponse();
    AddBusResponse addBusResponse= new AddBusResponse();
    addBusResponse.setBusName(trip.getBus().getBusName());
    addBusResponse.setBusNumber(trip.getBus().getBusNumber());
    addBusResponse.setTotalSeats(trip.getBus().getTotalSeats());

    RouteResponseDTO routeResponseDTO= new RouteResponseDTO();
    routeResponseDTO.setFrom(trip.getRoute().getFrom());
    routeResponseDTO.setTo(trip.getRoute().getTo());

    tripSearchResponse.setId(trip.getId());
    tripSearchResponse.setDepartureTime(trip.getDepartureTime());
    tripSearchResponse.setArrivalTime(trip.getArrivalTime());
    tripSearchResponse.setPrice(trip.getPrice());
    tripSearchResponse.setAvailableSeats(trip.getAvailableSeats());
    tripSearchResponse.setAddBusResponse(addBusResponse);
    tripSearchResponse.setRouteResponseDTO(routeResponseDTO);
tripSearchResponses.add(tripSearchResponse);
}
return tripSearchResponses;
}





public SeatDisplayDto getTripByID(Long id){
        SeatDisplayDto seatDisplayDto= new SeatDisplayDto();
Trip trip= tripRepository.getTripById(id);
seatDisplayDto.setAvailableSeats(trip.getAvailableSeats());
int totalRow=trip.getAvailableSeats()/4;

char [] columns={'A','B','C','D'};
List<String> SeatLayout= new ArrayList<>();
for(int row=1;row<=totalRow;row++){
    for(char col:columns ){
        SeatLayout.add(row + " "+ col);
        System.out.println();
    }
}
seatDisplayDto.setSeatLayout(SeatLayout);
return  seatDisplayDto;
}





//    public SeatDisplayDto getTripByID(Long id) {
//        SeatDisplayDto seatDisplayDto = new SeatDisplayDto();
//
//        Trip trip = tripRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Trip not found"));
//
//        seatDisplayDto.setAvailableSeats(trip.getAvailableSeats());
//
//        int totalRows = trip.getAvailableSeats() / 4;
//        char[] columns = {'A', 'B', 'C', 'D'};
//        List<String> seatLayout = new ArrayList<>();
//
//        for(int row = 1; row <= totalRows; row++) {
//            for(char col : columns) {
//                seatLayout.add(row + "" + col); //
//            }
//        }
//
//        seatDisplayDto.setSeatLayout(seatLayout);
//        return seatDisplayDto;
//    }


public String bookSeat(Long id,Integer noofSeat){
    SeatDisplayDto seatDisplayDto= new SeatDisplayDto();
    Trip trip= tripRepository.findById(id).orElseThrow(() -> new RuntimeException("Trip not found"));
    trip.getAvailableSeats();

    if(trip.getAvailableSeats()<noofSeat){

        return "There is not this much seat available";
    }
int leftSeat= trip.getAvailableSeats()-noofSeat;
trip.setAvailableSeats(leftSeat);
tripRepository.save(trip);

return noofSeat + "Seats are booked";
    }




}
