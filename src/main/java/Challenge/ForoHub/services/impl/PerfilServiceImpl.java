package Challenge.ForoHub.services.impl;

import Challenge.ForoHub.models.Perfil;
import Challenge.ForoHub.repositories.PerfilRepository;
import Challenge.ForoHub.services.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilServiceImpl implements PerfilService {

    //Inyeccion de dependencia
    @Autowired
    private PerfilRepository perfilRepository;

    @Override
    public List<Perfil> listPerfil() {
        return List.of();
    }

    @Override
    public Perfil findByIdPerfil(Long id) {
        return null;
    }

    @Override
    public void addPerfil(Perfil perfil) {

    }

    @Override
    public void updatePerfil(Perfil perfil) {

    }

    @Override
    public void deletePerfil(Long id) {

    }
}
