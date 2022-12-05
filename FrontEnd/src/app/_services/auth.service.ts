import { Usuario } from './../models/Usuario';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

const AUTH_API = 'http://localhost:8080/api/mercado/usuarios/login';



const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient) { }

  baseURL = "http://localhost:8080/api/mercado/usuarios";


  login(email: string, password: string): Observable<any> {
    return this.http.post(AUTH_API, {
      email,
      password
    }, httpOptions);
  }

  cadastrar(usuario: Usuario): Observable<Usuario> {
    return this.http.post<Usuario>(`${this.baseURL}`, usuario);
  }

  entrar(usuario: Usuario): Observable<Usuario> {
    return this.http.post<Usuario>(`${this.baseURL}/login`, usuario);
  }


}
