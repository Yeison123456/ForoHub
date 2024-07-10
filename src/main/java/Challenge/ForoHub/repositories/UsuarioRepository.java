package Challenge.ForoHub.repositories;

import Challenge.ForoHub.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByCorreoElectronico(String username);

    @Query("SELECT u FROM Usuario u WHERE u.correoElectronico = :correo")
    Usuario findByCorreoElectronico2(@Param("correo") String correo);

}
