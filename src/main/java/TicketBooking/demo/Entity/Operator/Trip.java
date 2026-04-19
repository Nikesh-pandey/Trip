package TicketBooking.demo.Entity.Operator;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "triplist")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Double price;
    private Integer availableSeats;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    public Trip(){};

    public Trip(Long id, LocalDateTime departureTime, LocalDateTime arrivalTime, Double price, Integer availableSeats, Bus bus, Route route) {
        this.id = id;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.availableSeats = availableSeats;
        this.bus = bus;
        this.route = route;
    }

    public Long getId() { return id; }
    public LocalDateTime getDepartureTime() { return departureTime; }
    public LocalDateTime getArrivalTime() { return arrivalTime; }
    public Double getPrice() { return price; }
    public Integer getAvailableSeats() { return availableSeats; }
    public Bus getBus() { return bus; }
    public Route getRoute() { return route; }

    public void setId(Long id) { this.id = id; }
    public void setDepartureTime(LocalDateTime departureTime) { this.departureTime = departureTime; }
    public void setArrivalTime(LocalDateTime arrivalTime) { this.arrivalTime = arrivalTime; }
    public void setPrice(Double price) { this.price = price; }
    public void setAvailableSeats(Integer availableSeats) { this.availableSeats = availableSeats; }
    public void setBus(Bus bus) { this.bus = bus; }
    public void setRoute(Route route) { this.route = route; }
}