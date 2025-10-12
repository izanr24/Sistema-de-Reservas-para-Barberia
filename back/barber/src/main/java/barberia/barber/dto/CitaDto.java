package barberia.barber.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class CitaDto {

    private int id;
    private String clienteNombre;
    private String telefonoCliente;
    private String emailCliente;
    private String servicio;
    private String barbero;
    private LocalDate fecha;
    private LocalTime hora;
    private String comentarioAdicional;
    private double precio;

    public CitaDto() {}

    public CitaDto (int id, String clienteNombre, String telefonoCliente, String emailCliente, String servicio, String barbero, LocalDate fecha, LocalTime hora ,String comentarioAdicional, double precio) {

        this.id = id;
        this.clienteNombre = clienteNombre;
        this.telefonoCliente = telefonoCliente;
        this.emailCliente = emailCliente;
        this.servicio = servicio;
        this.barbero = barbero;
        this.fecha = fecha;
        this.hora = hora;
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

}