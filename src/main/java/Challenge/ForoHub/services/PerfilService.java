package Challenge.ForoHub.services;


import Challenge.ForoHub.models.Perfil;

import java.util.List;

public interface PerfilService {

    public List<Perfil> listPerfil();
    public Perfil findByIdPerfil(Long id);
    public void addPerfil(Perfil perfil);
    public void updatePerfil(Perfil perfil);
    public void deletePerfil(Long id);

}
