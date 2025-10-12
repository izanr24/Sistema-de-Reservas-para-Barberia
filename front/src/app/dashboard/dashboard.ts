import { Component } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Cita, CitaService } from '../cita.service/cita.service';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  templateUrl: 'dashboard.html',
  styleUrls: ['./dashboard.scss']
})
export class DashboardComponent {

  citas: Cita[] = [];

  fechaSeleccionada: string = new Date().toISOString().substring(0, 10); // hoy por defecto

  constructor(private citaService: CitaService) {

    this.cargarCitas(this.fechaSeleccionada);

  }

  cargarCitas(fecha: string) {

    this.citaService.obtenerCitasPorFecha(fecha).subscribe({

      next: (res) => {

        this.citas = res;

      },

      error: (err) => {

        console.error('Error al cargar citas:', err);

      }

    });

  }

  onFechaChange(event: any) {

    this.fechaSeleccionada = event.target.value;
    this.cargarCitas(this.fechaSeleccionada);

  }

  completarCita(cita: Cita) {

    this.citaService.completarCita(cita.id!).subscribe({

      next: (citaActualizada) => {

        // Actualiza la cita en la lista local

        const index = this.citas.findIndex(c => c.id === cita.id);

        if (index !== -1) {

          this.citas[index] = citaActualizada;

        }
        console.log('Cita actualizada:', citaActualizada);

      },

      error: (err) => {

        console.error('Error al completar cita:', err);
        alert('Error al actualizar la cita');

      }

    });

  }

  cancelarCita(cita: Cita) {

    if (confirm('¿Estás seguro de que quieres cancelar esta cita?')) {

      this.citaService.eliminarCita(cita.id!).subscribe({

        next: () => {

          console.log('Cita eliminada correctamente');
          this.RecargarCitas();

        },

        error: (err) => {

          console.error('Error al eliminar la cita:', err);
          alert('Error al cancelar la cita');

        }

      });

    }

  }

  RecargarCitas() {

    this.citaService.listarCitas().subscribe({

      next: (citas) => {

        this.citas = citas;

      },

      error: (err) => {

        console.error('Error al cargar citas:', err);

      }

    });

  }

}
