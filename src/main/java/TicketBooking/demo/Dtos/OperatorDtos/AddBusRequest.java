package TicketBooking.demo.Dtos.OperatorDtos;

public class AddBusRequest {

    private String busName;
    private String busNumber;
    private Integer totalSeats;

    public AddBusRequest(){};

    public AddBusRequest(String busName, String busNumber, Integer totalSeats) {
        this.busName = busName;
        this.busNumber = busNumber;
        this.totalSeats = totalSeats;
    }

    public String getBusName() {
        return busName;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }
}
