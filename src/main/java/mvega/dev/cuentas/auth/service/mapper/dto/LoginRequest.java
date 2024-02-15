package mvega.dev.cuentas.auth.service.mapper.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequest {
    String username;
    String password;
}
