import { MovEstoquePorTipo } from './../models/MovEstoquePorTipo';
import { TipoProduto } from './../models/Produto';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { MovEstoque } from '../models/MovEstoque';
import { MovEstoqueLucro } from '../models/MovEstoqueLucro';
import { MatSnackBar } from '@angular/material/snack-bar';


@Injectable({
  providedIn: 'root'
})
export class MovEstoqueService {

  baseURL = "http://localhost:8080/api/mercado/estoque";

  constructor(private http: HttpClient, private snack: MatSnackBar) {}

  listar(): Observable<MovEstoque[]> {
    return this.http.get<MovEstoque[]>(`${this.baseURL}/movimentacoes`);
  }

  listarPorId(id: number): Observable<MovEstoque[]> {
    return this.http.get<MovEstoque[]>(`${this.baseURL}/consulta/${id}`);
  }

  listarPorIdProduto(id: number): Observable<MovEstoque[]> {
    return this.http.get<MovEstoque[]>(`${this.baseURL}/movimentoproduto/${id}`);
  }

  listarPorTipo(tipo: TipoProduto): Observable<MovEstoquePorTipo[]> {
    return this.http.get<MovEstoquePorTipo[]>(`${this.baseURL}/movimentoprodutoportipo/${tipo}`)
   // .pipe(catchError(this.handleError))
   ;}

  listarLucro(): Observable<MovEstoqueLucro[]> {
    return this.http.get<MovEstoqueLucro[]>(`${this.baseURL}/movimentofinanceiro`);
  }

  cadastrar(movEstoque: MovEstoque): Observable<MovEstoque> {
    return this.http.post<MovEstoque>(`${this.baseURL}/movimento`, movEstoque)
       // .pipe(catchError(this.handleError))
    ;}

  deletar(id: number): Observable<any> {
    return this.http.delete(`${this.baseURL}/excluimovimentacao/${id}`);
  }

/*
  private handleError(error: HttpErrorResponse) {
    if (error.status === 404) {

      // A client-side or network error occurred. Handle it accordingly.
      console.error('O estoque deste produto não permite essa movimentação', error.error);


    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${error.status}, body was: `, error.error);

    }
    // Return an observable with a user-facing error message.
    return throwError(() => new Error('Something bad happened; please try again later.'));
  }
*/
}
