package TicketBooking.demo.Dtos.PassengerDtos;

import java.util.List;
public class SeatDisplayDto {
    private Integer availableSeats;
    private List<String> seatLayout;

    public SeatDisplayDto(){};

    public Integer getAvailableSeats() { return availableSeats; }
    public List<String> getSeatLayout() { return seatLayout; }

    public void setAvailableSeats(Integer availableSeats) { this.availableSeats = availableSeats; }
    public void setSeatLayout(List<String> seatLayout) { this.seatLayout = seatLayout; }
}