package barberia.barber.entity;

import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

@Entity
@Table(name="citas")
public class CitaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="clientenombre")
    private String clienteNombre;

    @Column(name="telefonocliente")
    private String telefonoCliente;

    @Column(name="emailcliente")
    private String emailCliente;

    @Column
    private String servicio;

    @Column
    private String barbero;

    @Column
    private LocalDate fecha;

    @Column
    private LocalTime hora;

    @Column(name="comentarioadicional")
    private String comentarioAdicional;

    @Column
    private double precio;

    @Column
    private boolean completada = false;

    // Constructor vacío requerido por Hibernate
    public CitaEntity() {}

    public CitaEntity (int id, String clienteNombre, String telefonoCliente, String emailCliente, String servicio, String barbero, LocalDate fecha, String comentarioAdicional, double precio) {

        this.id = id;
        this.clienteNombre = clienteNombre;
        this.telefonoCliente = telefonoCliente;
        this.emailCliente = emailCliente;
        this.servicio = servicio;
        this.barbero = barbero;
        this.fecha = fecha;
        this.comentarioAdicional = comentarioAdicional;
        this.precio = precio;

    }

    public int getId() {

        return id;

    }

    public void setId (int id) {

        this.id = id;

    }

    public String getClienteNombre() {

        return clienteNombre;

    }

    public void setClienteNombre (String clienteNombre) {

        this.clienteNombre = clienteNombre;

    }

    public String getTelefonoCliente() {

        return telefonoCliente;

    }

    public void setTelefonoCliente (String telefonoCliente) {

        this.telefonoCliente = telefonoCliente;

    }

    public String getEmailCliente() {

        return emailCliente;

    }

    public void setEmailCliente (String emailCliente) {

        this.emailCliente = emailCliente;

    }

    public String getServicio() {

        return servicio;

    }

    public void setServicio (String servicio) {

        this.servicio = servicio;

    }

    public String getBarbero() {

        return barbero;

    }

    public void setBarbero (String barbero) {

        this.barbero = barbero;

    }

    public LocalDate getFecha() {

        return fecha;

    }

    public void setFecha (LocalDate fecha) {

        this.fecha = fecha;

    }

    public LocalTime getHora() {

        return hora;

    }

    public void setHora (LocalTime hora) {

        this.hora = hora;

    }

    public String getComentarioAdicional() {

        return comentarioAdicional;

    }

    public void setComentarioAdicional (String comentarioAdicional) {

        this.comentarioAdicional = comentarioAdicional;

    }

    public double getPrecio() {

        return precio;

    }

    public void setPrecio (double precio) {

        this.precio = precio;

    }

    public boolean isCompletada() {

        return completada;

    }

    public void setCompletada (boolean completada) {

        this.completada = completada;

    }

}
