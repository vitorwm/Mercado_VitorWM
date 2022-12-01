import { MovEstoqueLucro } from './../../../../models/MovEstoqueLucro';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MovEstoqueService } from 'src/app/services/movEstoque.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listar-lucro',
  templateUrl: './listar-lucro.component.html',
  styleUrls: ['./listar-lucro.component.css']
})
export class ListarLucroComponent implements OnInit {


  lucros!: MatTableDataSource<MovEstoqueLucro>

  displayedColumns: string[] =
  ['id', 'descricao', 'estoque','vendas', 'lucroTotal' , 'tipo'];

  constructor(private service: MovEstoqueService, private router:Router) {}

 ngOnInit(): void {
    this.service.listarLucro().subscribe((lucros) => {
      this.lucros = new MatTableDataSource<MovEstoqueLucro>(lucros);

    });
  }

}
