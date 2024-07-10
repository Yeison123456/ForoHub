package Challenge.ForoHub.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "topico")
@EqualsAndHashCode(of = "id")
public class Topico implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 55)
    private String titulo;

    @Column(nullable = false, length = 255)
    private String mensaje;

    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaCreacion;

    @Column(nullable = false)
    private Boolean status;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_curso_fk", nullable = false)
    private Curso idCursoFK;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_autor_fk", nullable = false)
    private Usuario idAutorFK;

    @JsonIgnore
    @OneToMany(mappedBy = "idTopicoFK", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Respuesta> respuestaList;

    @Override
    public String toString() {
        return "Topico{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", status=" + status +
                '}';
    }




}
