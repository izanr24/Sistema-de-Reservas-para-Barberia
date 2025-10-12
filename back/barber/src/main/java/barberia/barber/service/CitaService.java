package barberia.barber.service;

import java.time.LocalDate;

import java.util.List;

import barberia.barber.entity.CitaEntity;

public interface CitaService {

    CitaEntity crearCita (CitaEntity cita);

    List <CitaEntity> listarCitas();

    List <CitaEntity> obtenerCitasPorFecha (LocalDate fecha);

    void eliminarCita (int id);

    List <CitaEntity> obtenerCitasPorFechaYBarbero (LocalDate fecha, String barbero);

    CitaEntity completarCita (int id);

}
