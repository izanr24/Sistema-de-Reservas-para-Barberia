import { Component, EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({

  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  styleUrls: ['./login.scss'],
  template: `

  <div class="row justify-content-end me-5">

    <div class="col-sm-2 col-md-2 col-lg-1 home">

      <a data-scroll class="nav-link active" href="../index/index.html"> Home <span class="sr-only"></span> </a>

    </div>

  </div>

  <div class="mt-5 text-center">

    <h2> Iniciar sesión </h2>

  </div>

  <div class="container">

    <div class="row justify-content-center formulario mt-5">

      <div class="col-md-5">

        <div class="mt-5 text-center">

          <form (ngSubmit)="onSubmit()">

            <div class="form-group mb-5">

              <label class="form-label"> Usuario </label> 
              <input type="text" class="form-control" [(ngModel)]="username" name="username" placeholder="Usuario..." required />

            </div>

            <div class="form-group">

              <label class="form-label"> Contraseña: </label>
              <input type="password" class="form-control" [(ngModel)]="password" name="password" placeholder="Contraseña..." required />

            </div>

            <button class="menu-btn mt-5 mb-5" type="submit"> Iniciar sesión </button>

          </form>

        </div>

      </div>

    </div>

  </div>

  `

})

export class LoginComponent {

  username = '';
  password = '';

  @Output() loginSuccess = new EventEmitter<void>();

  constructor(private http: HttpClient, private router: Router) {}

  onSubmit() {

    this.http.post('http://localhost:8080/auth/login', { username: this.username, password: this.password }, { responseType: 'text' })

      .subscribe({

        next: (token) => {

          localStorage.setItem('token', token); // guardamos el Jwt
          this.loginSuccess.emit();
          this.router.navigate(['/dashboard']); // Redirigir al dashboard

        },

        error: (err) => alert('Usuario o contraseña incorrecta')

      });

  }

}