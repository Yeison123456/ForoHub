package Challenge.ForoHub.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
@EqualsAndHashCode(of = "id")
public class Usuario implements Serializable, UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 155)
    private String nombre;

    @Column(name = "correo_electronico", nullable = false, length = 255)
    private String correoElectronico;

    @Column(nullable = false, length = 55)
    private String contrasena;

    @JsonIgnore
    @OneToMany(mappedBy = "idAutorFK", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Topico> topicoList;

    @JsonIgnore
    @OneToMany(mappedBy = "idAutorFK", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Respuesta> respuestaList;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_perfil_fk", nullable = false)
    private Perfil idPerfilFK;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return correoElectronico;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }

}
