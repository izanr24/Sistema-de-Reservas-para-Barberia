import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiUrl = 'http://localhost:8080/auth/login';

  constructor(private http: HttpClient) {}

  login(username: string, password: string) {

    return this.http.post<{ token: string }>(this.apiUrl, { username, password })

      .pipe(

        tap(res => {

          localStorage.setItem('jwtToken', res.token);

        })

      );

  }

  logout() {

    localStorage.removeItem('jwtToken');

  }

  isLoggedIn(): boolean {

    return !!localStorage.getItem('jwtToken');

  }

}
