import { MovEstoqueService } from 'src/app/services/movEstoque.service';
import { MovEstoquePorTipo } from './../../../../models/MovEstoquePorTipo';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { TipoProduto } from 'src/app/models/Produto';

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


  constructor( private service: MovEstoqueService, private router: Router, private route: ActivatedRoute) {}

  ngOnInit(): void {
  }

  listarPorTipo(tipo: TipoProduto){
    this.service.listarPorTipo(tipo).subscribe((produtos) => {
      this.produtos = new MatTableDataSource<MovEstoquePorTipo>(produtos);

    });
  }

}
