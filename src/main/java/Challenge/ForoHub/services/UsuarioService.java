package Challenge.ForoHub.services;

import Challenge.ForoHub.dtos.DatosUsuario;
import Challenge.ForoHub.models.Usuario;

import java.util.List;

public interface UsuarioService {

    public List<DatosUsuario> listUsuario();
    public DatosUsuario findByIdUsuario(Long id);
    void addUsuario(DatosUsuario datosUsuario);
    void updateUsuario(DatosUsuario datosUsuario, Long id);
    public void deleteUsuario(Long id);

}
