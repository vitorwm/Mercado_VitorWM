import { MovEstoque } from './../../../../models/MovEstoque';
import { MovEstoqueService } from './../../../../services/movEstoque.service';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Produto } from 'src/app/models/Produto';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarMovimentoComponent implements OnInit {


  movimentos!: MatTableDataSource<MovEstoque>;
  produtos!: MatTableDataSource<Produto>;

  displayedColumns: string[] =
  ['id', 'tipoMovimento', 'valorVenda','qtdeMovimentada', 'data' ,
   'id_produto', 'descricao','tipo','valorFornecedor','estoque' , 'deletar'];

  constructor(private service: MovEstoqueService, private router:Router) {}


  ngOnInit(): void {
    this.service.listar().subscribe((movimentos) => {
      this.movimentos = new MatTableDataSource<MovEstoque>(movimentos);

    });
  }
/*
  ngOnInit(): void {
    this.retrieveTutorials();


  }
/*
  retrieveTutorials(): void {
    this.service.listar()
      .subscribe({
        next: (data) => {
          this.movimentos = new MatTableDataSource<MovEstoque>(movimentos);
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }
*/

  deletar(id: number) {
    this.service.deletar(id)
      .subscribe
        (data => {
        this.ngOnInit;
      })
      this.router.navigate([""]);
  }
}

