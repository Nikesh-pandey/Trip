package TicketBooking.demo.Dtos.RouteDtos;

import TicketBooking.demo.Enums.Route.Location;

public class RouteRequestDto {
    private Location from;
    private Location to;

    public RouteRequestDto() {
    }

    public RouteRequestDto(Location from, Location to) {
        this.from = from;
        this.to = to;
    }

    public void setFrom(Location from) {
        this.from = from;
    }

    public void setTo(Location to) {
        this.to = to;
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
    }
}