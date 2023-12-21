package pe.edu.idat.appwebtickets.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.idat.appwebtickets.model.bd.Ciudadano;
import pe.edu.idat.appwebtickets.model.request.CiudadanoRequest;
import pe.edu.idat.appwebtickets.model.response.ResultadoResponse;
import pe.edu.idat.appwebtickets.repository.CiudadanoRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CiudadanoService {
    private CiudadanoRepository ciudadanoRepository;

    public List<Ciudadano> listarCiudadanos(){

        return ciudadanoRepository.findAll();
    }

    public ResultadoResponse guardarCiudadano(CiudadanoRequest ciudadanoRequest){
        String mensaje = "Operación correcta";
        Boolean respuesta = true;
        try {
            Ciudadano ciudadano = new Ciudadano();
            if (ciudadanoRequest.getIdciu() > 0) {
                ciudadano.setIdciu(ciudadanoRequest.getIdciu());
            }
            ciudadano.setDniciu(ciudadanoRequest.getDniciu());
            ciudadano.setNombresc(ciudadanoRequest.getNombresc());
            ciudadano.setApellidosc(ciudadanoRequest.getApellidosc());
            ciudadano.setDireccionc(ciudadanoRequest.getDireccionc());
            ciudadano.setTelefono(ciudadanoRequest.getTelefono());
            ciudadano.setCorreoc(ciudadanoRequest.getCorreoc());

            ciudadanoRepository.save(ciudadano);
        }catch (Exception ex) {
            mensaje = "Operación incorrecta";
            respuesta = false;
        }

        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
