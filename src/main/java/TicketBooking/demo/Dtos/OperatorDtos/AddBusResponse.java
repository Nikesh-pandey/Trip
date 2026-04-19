package TicketBooking.demo.Dtos.OperatorDtos;

public class AddBusResponse {
private Long id;
    private String busName;
    private String busNumber;
    private Integer totalSeats;

    public AddBusResponse(){};

    public AddBusResponse(Long id) {
        this.id = id;
    }

    public AddBusResponse(String busName, String busNumber, Integer totalSeats) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
