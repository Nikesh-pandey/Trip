package TicketBooking.demo.Entity.Operator;

import TicketBooking.demo.Enums.Route.Location;
import jakarta.persistence.*;

@Entity
@Table(name = "route", uniqueConstraints = @UniqueConstraint(
        columnNames = {"from_location", "to_location"}))
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "from_location") // ✅ avoid reserved word
    private Location from;
    @Enumerated(EnumType.STRING)
    @Column(name = "to_location")
    private Location to;

    public Route() {
    }

    public Route(Long id, Location from, Location to) {
        this.id = id;
        this.from = from;
        this.to = to;
    }

    public Long getId() {
        return id;
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFrom(Location from) {
        this.from = from;
    }

    public void setTo(Location to) {
        this.to = to;
    }
}