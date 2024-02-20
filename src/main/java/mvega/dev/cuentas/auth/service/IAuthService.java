package mvega.dev.cuentas.auth.service;

import mvega.dev.cuentas.auth.persistence.entity.User;
import mvega.dev.cuentas.auth.service.mapper.dto.AuthResponse;
import mvega.dev.cuentas.auth.service.mapper.dto.LoginRequest;
import mvega.dev.cuentas.auth.service.mapper.dto.RegisterRequest;

import java.util.List;
import java.util.UUID;

public interface IAuthService {
    AuthResponse login(LoginRequest loginRequest);

    AuthResponse register(RegisterRequest registerRequest);

}
