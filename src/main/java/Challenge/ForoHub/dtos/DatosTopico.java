package Challenge.ForoHub.dtos;


import java.util.Date;

public record DatosTopico(
        String titulo,
        String mensaje,
        Date fechaCreacion,
        Boolean status
) {
}
