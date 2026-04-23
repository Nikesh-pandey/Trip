package TicketBooking.demo.Repository.Operator;

import TicketBooking.demo.Entity.Operator.Route;
import TicketBooking.demo.Enums.Route.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RouteRepository extends JpaRepository<Route,Long> {
    Optional<Route> findByFromAndTo(Location from, Location to);
}
