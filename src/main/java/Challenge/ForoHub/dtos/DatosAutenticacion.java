package Challenge.ForoHub.dtos;

import jakarta.validation.constraints.*;

public record DatosAutenticacion(
        @Email(message = "Formato correo no valido")
        @NotBlank(message = "El correo no puede quedar en blanco")
        String correoElectronico,
        @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
        @NotBlank(message = "La contraseña no puede quedar en blanco")
        String contrasena) {
}
