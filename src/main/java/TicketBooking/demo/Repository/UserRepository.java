package TicketBooking.demo.Repository;

import TicketBooking.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);  //if duplicate email find it will through exception
}
