package TicketBooking.demo.Dtos.RouteDtos;

import TicketBooking.demo.Enums.Route.Location;

public class RouteResponseDTO {
    private Location from;
    private Location to;

    public RouteResponseDTO() {
    }

    public RouteResponseDTO(Location from, Location to) {
        this.from = from;
        this.to = to;
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
    }

    public void setFrom(Location from) {
        this.from = from;
    }

    public void setTo(Location to) {
        this.to = to;
    }
}