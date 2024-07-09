package Challenge.ForoHub.services.impl;

import Challenge.ForoHub.models.Usuario;
import Challenge.ForoHub.repositories.UsuarioRepository;
import Challenge.ForoHub.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    //Inyeccion de dependencia
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listUsuario() {
        return List.of();
    }

    @Override
    public Usuario findByIdUsuario(Long id) {
        return null;
    }

    @Override
    public void addUsuario(Usuario usuario) {

    }

    @Override
    public void updateUsuario(Usuario usuario) {

    }

    @Override
    public void deleteUsuario(Long id) {

    }
}
