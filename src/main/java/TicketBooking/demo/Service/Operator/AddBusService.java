package TicketBooking.demo.Service.Operator;

import TicketBooking.demo.Dtos.OperatorDtos.AddBusRequest;
import TicketBooking.demo.Dtos.OperatorDtos.AddBusResponse;
import TicketBooking.demo.Entity.Operator.Bus;
import TicketBooking.demo.Repository.Operator.BusRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import TicketBooking.demo.Entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddBusService {
    private final BusRepository busRepository;

    public AddBusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    public AddBusResponse BusRequest(AddBusRequest addBusRequest){

    User operator= (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();


        Bus bus = new Bus();

        bus.setBusName(addBusRequest.getBusName());
        bus.setBusNumber(addBusRequest.getBusNumber());
        bus.setTotalSeats(addBusRequest.getTotalSeats());
        bus.setUser(operator);
        busRepository.save(bus);

        AddBusResponse addBusResponse= new AddBusResponse();
        addBusResponse.setBusName(bus.getBusName());
        addBusResponse.setBusNumber(bus.getBusNumber());
        addBusResponse.setTotalSeats(bus.getTotalSeats());

        return addBusResponse;
    }


    public List<AddBusResponse> getAll(){

        List<Bus> bus= busRepository.findAll();
        List<AddBusResponse> addBusResponses= new ArrayList<>();
        for(Bus busList: bus){
            AddBusResponse addBusResponse1= new AddBusResponse();
addBusResponse1.setId(busList.getId());
            addBusResponse1.setBusName(busList.getBusName());
            addBusResponse1.setBusNumber(busList.getBusNumber());
addBusResponse1.setTotalSeats(busList.getTotalSeats());
        addBusResponses.add(addBusResponse1);

        }
        return addBusResponses;
    }


    public AddBusResponse getById(Long id) {
        Bus bus = busRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bus not found"));

        AddBusResponse addBusResponse = new AddBusResponse();
        addBusResponse.setId(bus.getId());
        addBusResponse.setBusName(bus.getBusName());
        addBusResponse.setBusNumber(bus.getBusNumber());
        addBusResponse.setTotalSeats(bus.getTotalSeats());

        return addBusResponse;
    }

}
