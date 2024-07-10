package Challenge.ForoHub.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "perfil")
@EqualsAndHashCode(of = "id")
public class Perfil implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 55)
    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "idPerfilFK",  cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Usuario> usuarioList;



}
