import { MovEstoqueService } from 'src/app/services/movEstoque.service';
import { MovEstoquePorTipo } from './../../../../models/MovEstoquePorTipo';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { TipoProduto } from 'src/app/models/Produto';
import { HttpErrorResponse } from '@angular/common/http';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-listar-por-tipo',
  templateUrl: './listar-por-tipo.component.html',
  styleUrls: ['./listar-por-tipo.component.css']
})
export class ListarPorTipoComponent implements OnInit {

  tipo!: TipoProduto;

  produtos!: MatTableDataSource<MovEstoquePorTipo>


  displayedColumns: string[] =
  ['id', 'descricao', 'estoque','vendas', 'valorFornecedor' , 'tipo'];


  constructor( private service: MovEstoqueService, private snack: MatSnackBar, private router: Router, private route: ActivatedRoute) {}

  ngOnInit(): void {
  }

  listarPorTipo(tipo: TipoProduto){
    this.service.listarPorTipo(tipo).subscribe((produtos) => {
      this.produtos = new MatTableDataSource<MovEstoquePorTipo>(produtos);

    },err => {
      if (err instanceof HttpErrorResponse)
      {
          if (err.status === 404)
          {
            console.log(err)
            this.snack.open("ERRO! Ainda não houve movimentação desse tipo de produto!", "", {
              duration: 5000,
              horizontalPosition: "center",
              verticalPosition: "top",
            });
          }
      }
    });
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.produtos.filter = filterValue.trim().toLowerCase();
  }

}
