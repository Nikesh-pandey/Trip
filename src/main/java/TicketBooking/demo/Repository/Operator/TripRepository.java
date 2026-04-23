package TicketBooking.demo.Repository.Operator;

import TicketBooking.demo.Entity.Operator.Route;
import TicketBooking.demo.Entity.Operator.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip,Long> {
    List<Trip> findByRoute(Route route);

    List<Trip> id(Long id);

    Trip getTripById(Long id);
}
