package Challenge.ForoHub.utils.security.filters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import Challenge.ForoHub.Http.ResponseError;
import Challenge.ForoHub.repositories.UsuarioRepository;
import Challenge.ForoHub.utils.errors.TokenInvalidoException;
import Challenge.ForoHub.utils.security.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var authHeader = request.getHeader("Authorization");
        if (authHeader != null) {
            var token = authHeader.replace("Bearer ", "");
            try {
                var nombreUsuario = tokenService.getSubject(token); // extract username
                if (nombreUsuario != null) {
                    var usuario = usuarioRepository.findByCorreoElectronico(nombreUsuario);
                    var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            } catch (TokenInvalidoException e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

                ResponseError responseError = new ResponseError();
                responseError.setError(e.getMessage());
                responseError.setStatus(HttpStatus.UNAUTHORIZED.value());
                responseError.setMessage("Error de autenticación: " + e.getMessage());
                responseError.setPath("/error/login");

                Map<String, Object> responseMap = new HashMap<>();
                responseMap.put("error", responseError.getError());
                responseMap.put("status", responseError.getStatus());
                responseMap.put("message", responseError.getMessage());
                responseMap.put("path", responseError.getPath());

                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    String jsonResponse = objectMapper.writeValueAsString(responseMap);
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    response.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
                    response.getWriter().write(jsonResponse);
                } catch (JsonProcessingException | UnsupportedEncodingException es) {
                    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    response.getWriter().write("Error al procesar la respuesta");
                }
                return;
            }
        } 
        filterChain.doFilter(request, response);
    }
}