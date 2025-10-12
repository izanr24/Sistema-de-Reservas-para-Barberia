package barberia.barber.service.impl;

import barberia.barber.entity.CitaEntity;
import barberia.barber.service.CitaService;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import barberia.barber.repository.CitaRepository;



@Service
public class CitaServiceImpl implements CitaService {

    @Autowired
    private CitaRepository cr;

    // CREAR CITA

    @Override
    public CitaEntity crearCita (CitaEntity cita) {

        return cr.save(cita);

    }

    // LISTAR TODAS LAS CITAS

    @Override
    public List <CitaEntity> listarCitas() {

        return cr.selectAllCitas();

    }

    // OBTENER CITA POR FECHA

    @Override
    public List <CitaEntity> obtenerCitasPorFecha (LocalDate fecha) {

        return cr.selectByFecha(fecha);

    }

    // ELIMINAR CITA

    @Override
    public  void eliminarCita (int id) {

        cr.deleteById(id);

    }

    // OBTENER CITAS POR FECHA Y BARBERO

    @Override
    public List <CitaEntity> obtenerCitasPorFechaYBarbero (LocalDate fecha, String barbero) {

        return cr.selectByFechaAndBarbero(fecha, barbero);

    }

    // COMPLETAR CITA

    @Override
    public CitaEntity completarCita (int id) {

        CitaEntity cita = cr.findById(id).orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        cita.setCompletada(!cita.isCompletada()); // Toggle del estado
        return cr.save(cita);

    }

}
