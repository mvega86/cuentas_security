package mvega.dev.cuentas.src.service.mapper.dto;

import lombok.*;
import mvega.dev.cuentas.src.persistence.entity.Concepto;
import mvega.dev.cuentas.src.persistence.entity.EPrioridad;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdDetalleDTO {
    private String nombre;
    private BigDecimal precio;
    private String proveedor;
    private EPrioridad prioridad;
    private Concepto concepto_detalle;
}
