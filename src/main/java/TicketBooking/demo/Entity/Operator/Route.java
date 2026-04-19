package TicketBooking.demo.Entity.Operator;

import jakarta.persistence.*;

@Entity
@Table(name = "route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fromLocation;
    private String toLocation;

    public Route(){}

    public Route(Long id, String fromLocation, String toLocation) {
        this.id = id;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
    }

    public Long getId() { return id; }
    public String getFromLocation() { return fromLocation; }
    public String getToLocation() { return toLocation; }

    public void setId(Long id) { this.id = id; }
    public void setFromLocation(String fromLocation) { this.fromLocation = fromLocation; }
    public void setToLocation(String toLocation) { this.toLocation = toLocation; }
}