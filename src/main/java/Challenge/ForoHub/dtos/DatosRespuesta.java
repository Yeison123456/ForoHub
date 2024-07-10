package Challenge.ForoHub.dtos;


import java.util.Date;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosRespuesta{
    Long id;
    String mensaje;
    Date fechaCreacion;
    String solucion;
}
