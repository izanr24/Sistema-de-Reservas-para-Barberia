package barberia.barber.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import barberia.barber.entity.CitaEntity;
import jakarta.transaction.Transactional;

public interface CitaRepository extends JpaRepository <CitaEntity, Integer> {

    // LISTAR TODAS CITAS

    @Query(value = "SELECT * FROM citas", nativeQuery = true)
    List <CitaEntity> selectAllCitas();

    // LISTAR CITA POR FECHA

    @Query(value = "SELECT * FROM citas WHERE fecha = :fecha", nativeQuery = true)
    List <CitaEntity>  selectByFecha (LocalDate fecha);

    // CREAR CITA

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO citas (clienteNombre, telefonoCliente, emailCliente, servicio, barbero, fecha, hora,comentarioAdicional, precio)" + 
                    "VALUES (:clienteNombre, :telefonoCliente, :emailCliente, :servicio, :barbero, :fecha, :hora,:comentarioAdicional, :precio)", nativeQuery = true)
    CitaEntity crearCita (@Param ("clienteNombre") String clienteNombre,
                        @Param ("telefonoCliente") String telefonoCliente,
                        @Param ("emailCliente") String emailCliente,
                        @Param ("servicio") String servicio,
                        @Param ("barbero") String barbero,
                        @Param ("fecha ") LocalDate fecha,
                        @Param ("hora")  LocalTime hora,
                        @Param ("comentarioAdicional") String comentarioAdicional,
                        @Param ("precio") double precio);

    // ELIMINAR CITA POR ID

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM citas WHERE id = :id", nativeQuery = true)
    void eliminarCita (@Param ("id") int id);

    // LISTAR CITAS POR FECHA Y BARBERO

    @Query(value = "SELECT * FROM citas WHERE fecha = :fecha AND barbero = :barbero", nativeQuery = true)
    List <CitaEntity> selectByFechaAndBarbero (@Param ("fecha") LocalDate fecha, @Param ("barbero") String barbero);

}
