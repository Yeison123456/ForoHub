package Challenge.ForoHub.services.impl;

import Challenge.ForoHub.models.Respuesta;
import Challenge.ForoHub.repositories.RespuestaRepository;
import Challenge.ForoHub.services.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespuestaServiceImpl implements RespuestaService {

    //Inyeccion de dependencia
    @Autowired
    private RespuestaRepository respuestaRepository;

    @Override
    public List<Respuesta> listRespuesta() {
        return List.of();
    }

    @Override
    public Respuesta findByIdRespuesta(Long id) {
        return null;
    }

    @Override
    public void addRespuesta(Respuesta respuesta) {

    }

    @Override
    public void updateRespuesta(Respuesta respuesta) {

    }

    @Override
    public void deleteRespuesta(Long id) {

    }
}
