import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MovEstoque } from '../models/MovEstoque';


@Injectable({
  providedIn: 'root'
})
export class MovEstoqueService {

  baseURL = "http://localhost:8080/api/mercado/estoque";

  constructor(private http: HttpClient) {}

  listar(): Observable<MovEstoque[]> {
    return this.http.get<MovEstoque[]>(`${this.baseURL}/movimentacoes`);
  }

  cadastrar(movEstoque: MovEstoque): Observable<MovEstoque> {
    return this.http.post<MovEstoque>(`${this.baseURL}/movimento`, movEstoque);
  }

  deletar(id: number): Observable<any> {
    return this.http.delete(`${this.baseURL}/excluimovimentacao/${id}`);
  }
}