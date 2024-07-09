package Challenge.ForoHub.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
@EqualsAndHashCode(of = "id")
public class Usuario implements Serializable {

    //Columnas de la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 155)
    private String nombre;

    @Column(name = "correo_electronico", nullable = false, length = 255)
    private String correoElectronico;

    @Column(nullable = false, length = 55)
    private String contrasena;

    //Relaciones

}
