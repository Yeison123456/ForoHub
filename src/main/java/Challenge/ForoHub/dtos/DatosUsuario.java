package Challenge.ForoHub.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosUsuario{
    Long id;
    String nombre;
    String correoElectronico;
    String contrasena;
}
