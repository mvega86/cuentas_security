package mvega.dev.cuentas.auth.service.implementation;

import mvega.dev.cuentas.auth.persistence.repository.UserRepository;
import mvega.dev.cuentas.auth.service.mapper.RegisterRequestToUser;
import mvega.dev.cuentas.auth.service.mapper.dto.AuthResponse;
import mvega.dev.cuentas.auth.service.mapper.dto.LoginRequest;
import mvega.dev.cuentas.auth.service.mapper.dto.RegisterRequest;
import mvega.dev.cuentas.auth.persistence.entity.User;
import mvega.dev.cuentas.auth.service.IAuthService;
import mvega.dev.cuentas.exceptions.CuentasException;
import mvega.dev.cuentas.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements IAuthService {
    @Autowired
    private RegisterRequestToUser registerRequestToUser;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        Optional<User> optionalUser = userRepository.findByUsername(loginRequest.getUsername());
        if(optionalUser.isPresent()) {
            UserDetails user = optionalUser.get();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            System.out.println(user.getUsername());
            String token = jwtService.getToken(user);
            return AuthResponse.builder()
                    .token(token)
                    .build();
        }
        return null;
    }

    @Override
    public AuthResponse register(RegisterRequest registerRequest) {
        Optional<User> optionalUser = userRepository.findByUsername(registerRequest.getUsername());
        if (optionalUser.isPresent()){
            throw new CuentasException("Username already exist", HttpStatus.BAD_REQUEST);
        }
        User user = registerRequestToUser.map(registerRequest);
        userRepository.save(user);
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
