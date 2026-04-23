package TicketBooking.demo.Dtos.PassengerDtos;

import TicketBooking.demo.Dtos.OperatorDtos.AddBusResponse;
import TicketBooking.demo.Dtos.RouteDtos.RouteResponseDTO;
import TicketBooking.demo.Enums.Route.Location;

import java.time.LocalDateTime;

public class TripSearchResponse {
    private Long id;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Double price;
    private Integer availableSeats;
    private AddBusResponse addBusResponse;
    private RouteResponseDTO routeResponseDTO;
public TripSearchResponse(){};

    public TripSearchResponse(Long id,LocalDateTime departureTime, LocalDateTime arrivalTime, Double price, Integer availableSeats, AddBusResponse addBusResponse, RouteResponseDTO routeResponseDTO) {
        this.id=id;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.availableSeats = availableSeats;
        this.addBusResponse = addBusResponse;
        this.routeResponseDTO = routeResponseDTO;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public AddBusResponse getAddBusResponse() {
        return addBusResponse;
    }

    public RouteResponseDTO getRouteResponseDTO() {
        return routeResponseDTO;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void setAddBusResponse(AddBusResponse addBusResponse) {
        this.addBusResponse = addBusResponse;
    }

    public void setRouteResponseDTO(RouteResponseDTO routeResponseDTO) {
        this.routeResponseDTO = routeResponseDTO;
    }
}