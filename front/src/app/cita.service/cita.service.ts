// src/app/service/cita.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Cita {

  id?: number; // Campo opcional para cuando se crea (no tiene id) y requerido cuando se obtiene del backend
  clienteNombre: string;
  telefonoCliente: string;
  emailCliente: string;
  servicio: string;
  barbero: string;
  fecha: string;
  hora: string;
  comentarioAdicional?: string;
  precio: number;
  completada?: boolean;

}

@Injectable({

  providedIn: 'root'

})

export class CitaService {

  private apiUrl = 'http://localhost:8080/citas';

  constructor(private http: HttpClient) {}

  // Crear citas
  crearCita(cita: Cita): Observable<Cita> {

    return this.http.post<Cita>(this.apiUrl, cita);

  }

  // Listar todas las citas
  listarCitas(): Observable<Cita[]> {

    return this.http.get<Cita[]>(this.apiUrl);

  }

  // Obtener citas por fecha
  obtenerCitasPorFecha(fecha: string): Observable<Cita[]> {

    return this.http.get<Cita[]>(`${this.apiUrl}/fecha/${fecha}`);

  }

  // Eliminar cita por id
  eliminarCita(id: number): Observable<void> {

    return this.http.delete<void>(`${this.apiUrl}/${id}`);

  }

  // Obtener citas por fecha y barbero
  obtenerCitasPorFechaYBarbero(fecha: string, barbero: string): Observable<Cita[]> {

    return this.http.get<Cita[]>(`${this.apiUrl}/fecha/${fecha}/barbero/${barbero}`);

  }

  // Completar cita
  completarCita(id: number): Observable<Cita> {

    return this.http.post<Cita>(`${this.apiUrl}/${id}/completar`, {});

  }

}
