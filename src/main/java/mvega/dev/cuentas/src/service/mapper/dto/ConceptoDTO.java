package mvega.dev.cuentas.src.service.mapper.dto;

import jakarta.persistence.Column;
import lombok.*;
import mvega.dev.cuentas.src.persistence.entity.Cuenta;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConceptoDTO {
    private Long id;
    private String name;
    private List<Cuenta> cuentas;
}
