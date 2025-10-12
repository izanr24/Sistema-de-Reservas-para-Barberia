package barberia.barber.rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import barberia.barber.entity.CitaEntity;
import barberia.barber.service.CitaService;

@RestController
@RequestMapping("/citas")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8081"})
public class CitaRestController {

    @Autowired
    private CitaService cs;

    // CREAR CITA

    @PostMapping
    public CitaEntity crearCita (@RequestBody CitaEntity cita) {

        return cs.crearCita(cita);

    }

    // LISTAR CITAS

    @GetMapping
    public List <CitaEntity> listarCitas() {

        return cs.listarCitas();

    }

    // BUSCAR CITA POR FECHA

    @GetMapping("/fecha/{fecha}")
    public List <CitaEntity> obtenerCitasPorFecha (@PathVariable String fecha) {

        LocalDate fechaParsed = LocalDate.parse(fecha);

        return cs.obtenerCitasPorFecha(fechaParsed);

    }

    // ELIMINAR CITA

    @DeleteMapping("/{id}")
    public void eliminarCita (@PathVariable int id) {

        cs.eliminarCita(id);

    }

    // BUSCAR CITAS POR FECHA Y BARBERO

    @GetMapping("/fecha/{fecha}/barbero/{barbero}")
    public List <CitaEntity> obtenerCitasPorFechaYBarbero (@PathVariable String fecha, @PathVariable String barbero) {

        LocalDate fechaParsed = LocalDate.parse(fecha);

        return cs.obtenerCitasPorFechaYBarbero(fechaParsed, barbero);

    }

    // MARCAR CITA COMO COMPLETADA

    @PostMapping("/{id}/completar")
    public CitaEntity completarCita (@PathVariable int id) {

        return cs.completarCita(id);

    }

}