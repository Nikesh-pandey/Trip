package TicketBooking.demo.Dtos.TripDtos;

import TicketBooking.demo.Entity.Operator.Bus;
import TicketBooking.demo.Entity.Operator.Route;

import java.time.LocalDateTime;

public class TripRequestDtos {

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Double price;
    private Integer availableSeats;
    private Long busId;
    private Long routeId;

    public TripRequestDtos(){};

    public TripRequestDtos(LocalDateTime departureTime, LocalDateTime arrivalTime, Double price, Integer availableSeats, Long busId, Long routeId) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.availableSeats = availableSeats;
        this.busId = busId;
        this.routeId = routeId;
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

    public Long getBusId() {
        return busId;
    }

    public Long getRouteId() {
        return routeId;
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

    public void setBusId(Long busId) {
        this.busId = busId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }
}
