package Challenge.ForoHub.dtos;

import lombok.*;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosTopico{
    Long id;
    String titulo;
    String mensaje;
    Date fechaCreacion;
    Boolean status;
    Long idAutorFK;
    Long idCursoFK;
}
