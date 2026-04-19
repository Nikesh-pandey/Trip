package TicketBooking.demo.Entity.Operator;

import TicketBooking.demo.Entity.User;
import jakarta.persistence.*;

@Entity
@Table(name="bus_Details")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String busName;
    private String busNumber;
    private Integer totalSeats;

    @ManyToOne
    @JoinColumn(name = "operator_id")
    private User user;

    public Bus(){};

    public Bus(Long id, String busName, String busNumber, Integer totalSeats, User user) {
        this.id = id;
        this.busName = busName;
        this.busNumber = busNumber;
        this.totalSeats = totalSeats;
        this.user = user;
    }

    public Long getId() { return id; }
    public String getBusName() { return busName; }
    public String getBusNumber() { return busNumber; }
    public Integer getTotalSeats() { return totalSeats; }
    public User getUser() { return user; }

    public void setId(Long id) { this.id = id; }
    public void setBusName(String busName) { this.busName = busName; }
    public void setBusNumber(String busNumber) { this.busNumber = busNumber; }
    public void setTotalSeats(Integer totalSeats) { this.totalSeats = totalSeats; }
    public void setUser(User user) { this.user = user; }
}