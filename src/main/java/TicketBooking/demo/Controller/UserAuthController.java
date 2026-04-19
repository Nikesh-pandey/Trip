package TicketBooking.demo.Controller;


import TicketBooking.demo.Dtos.LoginDto;
import TicketBooking.demo.Dtos.RegistrationDto;
import TicketBooking.demo.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class UserAuthController {
    private final UserService userService;

    public UserAuthController(UserService userService) {
        this.userService = userService;
    }
@PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody  RegistrationDto registrationDto){
        return new ResponseEntity<>(userService.registerUser(registrationDto), HttpStatus.CREATED);
    }
@PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody  LoginDto loginDto){
String token=userService.loginUser(loginDto);
return  ResponseEntity.ok(Map.of("token",token));
    }

}
