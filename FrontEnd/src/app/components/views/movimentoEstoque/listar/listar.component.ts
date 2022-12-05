import { MovEstoque } from './../../../../models/MovEstoque';
import { MovEstoqueService } from './../../../../services/movEstoque.service';
import { MatTableDataSource } from '@angular/material/table';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarMovimentoComponent implements OnInit {

  movimentos!: MatTableDataSource<MovEstoque>;

  displayedColumns: string[] =
  ['id', 'tipoMovimentacao', 'valorVenda','qtdeMovimentada', 'data' ,
   'id_produto', 'descricao','tipo','valorFornecedor','estoque' , 'deletar'];

  constructor(private service: MovEstoqueService, private router:Router) {}


  ngOnInit(): void {
    this.service.listar().subscribe((movimentos) => {
      this.movimentos = new MatTableDataSource<MovEstoque>(movimentos);

    });
  }

  deletar(id: number) {
    this.service.deletar(id)
      .subscribe
        (data => {
          this.service.listar().subscribe((movimentos) => {
            this.movimentos = new MatTableDataSource<MovEstoque>(movimentos);

          });
      })

  }


  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.movimentos.filter = filterValue.trim().toLowerCase();
  }

}

