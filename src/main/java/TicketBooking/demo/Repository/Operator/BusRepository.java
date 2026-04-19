package TicketBooking.demo.Repository.Operator;

import TicketBooking.demo.Entity.Operator.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusRepository extends JpaRepository<Bus,Long> {

Optional<Bus> findById(long id);
}
