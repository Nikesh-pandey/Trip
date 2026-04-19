package TicketBooking.demo.Service;
import TicketBooking.demo.Config.JwtService;
import TicketBooking.demo.Entity.User;
import TicketBooking.demo.Dtos.RegistrationDto;
import TicketBooking.demo.Dtos.LoginDto;
import TicketBooking.demo.Repository.UserRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private  final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
private final AuthenticationProvider authenticationProvider;
    private final JwtService jwtService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserDetailsService userDetailsService, AuthenticationProvider authenticationProvider, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.authenticationProvider = authenticationProvider;
        this.jwtService = jwtService;
    }
    public String registerUser(RegistrationDto registrationDto){
        String encodedpassword=passwordEncoder.encode(registrationDto.getPassword());
registrationDto.setPassword(encodedpassword);
        User user= new User();

        user.setName(registrationDto.getName());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        user.setRole(registrationDto.getRole());

        userRepository.save(user);
        return "User Registered Successfully";

    }


    public String loginUser(LoginDto loginDto){

        User user= userRepository.findByEmail(loginDto.getEmail()).orElseThrow(null);
        authenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken(

                        loginDto.getEmail(),
                        loginDto.getPassword()

                )
        );

        String jwt= jwtService.generateToken(user);

return jwt;
    }


}
