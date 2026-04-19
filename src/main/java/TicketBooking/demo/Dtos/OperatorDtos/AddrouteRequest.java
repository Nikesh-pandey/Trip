package TicketBooking.demo.Dtos.OperatorDtos;

public class AddrouteRequest {

    private String fromLocation;
    private String toLocation;

    public AddrouteRequest(){};


    public AddrouteRequest(String fromLocation, String toLocation) {
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }
}
