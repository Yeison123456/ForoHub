package Challenge.ForoHub.services.impl;

import Challenge.ForoHub.dtos.DatosTopico;
import Challenge.ForoHub.models.Curso;
import Challenge.ForoHub.models.Topico;
import Challenge.ForoHub.models.Usuario;
import Challenge.ForoHub.repositories.CursoRepository;
import Challenge.ForoHub.repositories.TopicoRepository;
import Challenge.ForoHub.repositories.UsuarioRepository;
import Challenge.ForoHub.services.TopicoService;
import Challenge.ForoHub.utils.errors.CustomException;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicoServiceImpl implements TopicoService {

    //Inyeccion de dependencia
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<DatosTopico> listTopico() {

        List<Topico> topicoList = topicoRepository.findAll();
        List<DatosTopico> datosTopicoList = new ArrayList<>();

        topicoList.forEach(topico -> datosTopicoList.add(modelMapper.map(topico, DatosTopico.class)));


        return datosTopicoList;
    }

    @Override
    public DatosTopico findByIdTopico(Long id) {
        return modelMapper.map(topicoRepository.findById(id), DatosTopico.class);
    }

    @Override
    public void addTopico(DatosTopico datosTopico) {
        Topico topico = new Topico();
        topico.setStatus(datosTopico.getStatus());
        topico.setMensaje(datosTopico.getMensaje());
        topico.setTitulo(datosTopico.getTitulo());
        topico.setFechaCreacion(datosTopico.getFechaCreacion());
        try {
            Usuario usuario = usuarioRepository.getById(datosTopico.getIdAutorFK());
            System.out.println(usuario);
            Curso curso = cursoRepository.getById(datosTopico.getIdCursoFK());
            System.out.println(curso);
            topico.setIdAutorFK(usuario);
            topico.setIdCursoFK(curso);
            topicoRepository.save(topico);
        }catch (EntityNotFoundException ent){
            throw new CustomException("Not found relation data");
        }
        catch (Exception e){
            System.err.println(e.getMessage());
            throw new CustomException(e.getMessage());
        }
    }

    @Override
    public void updateTopico(DatosTopico datosTopico, Long id) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (optionalTopico.isPresent()) {
            Topico topico = optionalTopico.get();
            topico.setStatus(datosTopico.getStatus());
            topico.setMensaje(datosTopico.getMensaje());
            topico.setTitulo(datosTopico.getTitulo());
            topico.setFechaCreacion(datosTopico.getFechaCreacion());
            try {
                Usuario usuario = usuarioRepository.getById(datosTopico.getIdAutorFK());
                System.out.println(usuario);
                Curso curso = cursoRepository.getById(datosTopico.getIdCursoFK());
                System.out.println(curso);
                topico.setIdAutorFK(usuario);
                topico.setIdCursoFK(curso);
                topicoRepository.save(topico);
            } catch (EntityNotFoundException ent) {
                throw new CustomException("Not found relation data");
            } catch (Exception e) {
                System.err.println(e.getMessage());
                throw new CustomException(e.getMessage());
            }
        }else {
            throw new EntityNotFoundException("Topico not found");
        }
    }
    @Override
    public void deleteTopico(Long id) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        System.out.println(optionalTopico);
        if (optionalTopico.isPresent()) {
            try {
                topicoRepository.deleteById(id);
            } catch (Exception e) {
                throw new CustomException("Error de servidor");
            }
        } else {
            throw new EntityNotFoundException("Topico not found");
        }
    }
}
