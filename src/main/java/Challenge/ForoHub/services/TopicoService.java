package Challenge.ForoHub.services;

import Challenge.ForoHub.dtos.DatosTopico;
import Challenge.ForoHub.models.Topico;

import java.util.List;

public interface TopicoService {

    public List<DatosTopico> listTopico();
    public DatosTopico findByIdTopico(Long id);
    void addTopico(DatosTopico datosTopico);
    void updateTopico(DatosTopico datosTopico, Long id);
    public void deleteTopico(Long id);

}
