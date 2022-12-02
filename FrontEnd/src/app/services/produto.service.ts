import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Produto } from '../models/Produto';

@Injectable({
  providedIn: 'any'
})
export class ProdutoService {

  baseURL = "http://localhost:8080/api/mercado/produto";

  constructor(private http: HttpClient) {}

  listar(): Observable<Produto[]> {
    return this.http.get<Produto[]>(`${this.baseURL}/listar`);
  }

  cadastrar(produto: Produto): Observable<Produto> {
    return this.http.post<Produto>(`${this.baseURL}/novo`, produto);
  }

  deletar(id: number): Observable<any> {
    return this.http.delete(`${this.baseURL}/remove/${id}`);
  }


  listarPorId(id: number): Observable<Produto[]> {
    return this.http.get<Produto[]>(`${this.baseURL}/consulta/${id}`);
  }

  atualizar(id: number, produto: Produto): Observable<Object> {
    return this.http.put(`${this.baseURL}/atualiza/${id}`,produto);
  }


}
