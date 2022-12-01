import { TipoProduto } from './../models/Produto';
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

  listarPorId(id: number): Observable<MovEstoque[]> {
    return this.http.get<MovEstoque[]>(`${this.baseURL}/consulta/${id}`);
  }

  listarPorIdProduto(id: number): Observable<MovEstoque[]> {
    return this.http.get<MovEstoque[]>(`${this.baseURL}/movimentoproduto/${id}`);
  }

  listarPorTipo(tipo: TipoProduto): Observable<MovEstoque[]> {
    return this.http.get<MovEstoque[]>(`${this.baseURL}/movimentoprodutoportipo/${tipo}`);
  }

  listarLucro(): Observable<MovEstoque[]> {
    return this.http.get<MovEstoque[]>(`${this.baseURL}/movimentofinanceiro`);
  }

  cadastrar(movEstoque: MovEstoque): Observable<MovEstoque> {
    return this.http.post<MovEstoque>(`${this.baseURL}/movimento`, movEstoque);
  }

  deletar(id: number): Observable<any> {
    return this.http.delete(`${this.baseURL}/excluimovimentacao/${id}`);
  }
}
