package TicketBooking.demo.Repository.Operator;

import TicketBooking.demo.Entity.Operator.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip,Long> {
}
