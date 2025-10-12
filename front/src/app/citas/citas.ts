import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { Cita, CitaService } from '../cita.service/cita.service';
import { HttpClientModule } from '@angular/common/http';

interface Servicio {

  id: string;
  nombre: string;
  duracion: number;
  precio: number;
  seleccionado: boolean;

}

@Component({

  selector: 'app-citas',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule, RouterLink],
  templateUrl: './citas.html',
  styleUrls: ['./citas.scss']

})

export class CitasComponent {

  servicios: Servicio[] = [

    { id: 'corte', nombre: 'Corte de pelo', duracion: 30, precio: 8, seleccionado: false },
    { id: 'barba', nombre: 'Recorte de barba', duracion: 20, precio: 9, seleccionado: false },
    { id: 'afeitado', nombre: 'Afeitado completo', duracion: 25, precio: 10, seleccionado: false },
    { id: 'facial', nombre: 'Mascarilla facial', duracion: 45, precio: 15, seleccionado: false }

  ];

  get total(): number {

    return this.servicios

      .filter(s => s.seleccionado)
      .reduce((acc, s) => acc + s.precio, 0);

  }

  get duracionTotal(): number {

    return this.servicios

      .filter(s => s.seleccionado)
      .reduce((acc, s) => acc + s.duracion, 0);

  }

  fechaSeleccionada: string | null = null;
  horaSeleccionada: string | null = null;
  horasDisponibles: string[] = [];
  horasOcupadas: string[] = [];
  todasHoras: string[] = [

    '09:00', '09:30', '10:00', '10:30', '11:00', '11:30', '12:00', '12:30',
    '13:00', '13:30', '14:00', '14:30', '15:00', '15:30', '16:00', '16:30',
    '17:00', '17:30', '18:00', '18:30', '19:00', '19:30', '20:00', '20:30'

  ];

  citaConfirmada = false;

  cita = {

    nombre: '',
    telefono: '',
    email: '',
    servicio: '',
    barbero: '',
    fecha: '',
    hora: '',
    comentarioAdicional: '',
    precio: 0

  };

  constructor(private citaService: CitaService) { }

  onFechaChange(event: any) {

    this.fechaSeleccionada = event.target.value;
    this.cita.fecha = this.fechaSeleccionada || '';
    this.generarHorasDisponibles();

  }

  generarHorasDisponibles() {

    if (!this.fechaSeleccionada) {

      this.horasDisponibles = this.todasHoras;
      this.horasOcupadas = [];
      this.horaSeleccionada = '';
      return;

    }

    // Obtenemos todas las citas para la fecha seleccionada
    this.citaService.obtenerCitasPorFecha(this.fechaSeleccionada)

      .subscribe({

        next: (citas) => {

          // Convertimos el formato de hora de "09:00:00" a "09:00"
          this.horasOcupadas = citas.map(cita => cita.hora.substring(0, 5));
          this.horasDisponibles = this.todasHoras.filter(hora => !this.horasOcupadas.includes(hora));
          this.horaSeleccionada = '';

        },

        error: (err) => {

          console.error('Error al obtener citas:', err);
          this.horasDisponibles = this.todasHoras;
          this.horasOcupadas = [];
          this.horaSeleccionada = '';

        }

      });

  }

  seleccionarHora(hora: string) {

    if (!this.horasOcupadas.includes(hora)) {

      this.horaSeleccionada = hora;
      this.cita.hora = hora;

    }

  }

  isHoraOcupada(hora: string): boolean {

    return this.horasOcupadas.includes(hora);

  }

  toggleServicio(servicio: Servicio) {

    servicio.seleccionado = !servicio.seleccionado;

  }

  hayServiciosSeleccionados(): boolean {

    return this.servicios.some(s => s.seleccionado);

  }

  confirmarCita(form: NgForm) {

    if (form.invalid) {

      alert("Por favor, complete todos los campos antes de confirmar la cita.");
      return;

    }

    // Guardar todos los servicios seleccionados
    const serviciosSeleccionados = this.servicios

      .filter(s => s.seleccionado)
      .map(s => s.nombre);

    this.cita.servicio = serviciosSeleccionados.join(', ');

    // Calcular el precio total
    this.cita.precio = 0;
    for (let s of this.servicios) {

      if (s.seleccionado) {

        this.cita.precio += s.precio;

      }

    }

    // Barbero ya se asigna automáticamente con [(ngModel)] en el select

    const nuevaCita: Cita = {

      clienteNombre: this.cita.nombre,
      telefonoCliente: this.cita.telefono,
      emailCliente: this.cita.email,
      servicio: this.cita.servicio,
      barbero: this.cita.barbero,
      fecha: this.cita.fecha,
      hora: this.cita.hora,
      comentarioAdicional: this.cita.comentarioAdicional,
      precio: this.cita.precio

    };

    this.citaService.crearCita(nuevaCita).subscribe({

      next: (res) => {

        console.log('Cita creada:', res);
        this.citaConfirmada = true;

      },

      error: (err) => {

        console.error('Error al crear la cita:', err);
        alert('Hubo un error al crear la cita. Revisa la consola.');

      }

    });

  }

}
