import { Component, OnInit } from '@angular/core';

import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { Produto, TipoProduto } from 'src/app/models/Produto';
import { ProdutoService } from 'src/app/services/produto.service';

@Component({
  selector: 'app-atualizar',
  templateUrl: './atualizar.component.html',
  styleUrls: ['./atualizar.component.css']
})
export class AtualizarComponent implements OnInit {

  id!: number;
  descricao!: string;
  preco!: number;
  valorFornecedor!: number;
  estoque!: number;
  tipo!: TipoProduto;

  constructor( private produtoService: ProdutoService, private router: Router, private snack: MatSnackBar, private route: ActivatedRoute) {}


ngOnInit(): void {
  this.id = this.route.snapshot.params['id'];

}


  atualizar(id: number): void {

    let produto = new Produto();

    produto.id = this.id;
    produto.descricao = this.descricao;
    produto.tipo =(this.tipo);
    produto.valorFornecedor = this.valorFornecedor;
    produto.estoque = this.estoque;

    this.produtoService.atualizar(id,produto).subscribe(produto => {
      console.log(produto);
      this.snack.open("Produto atualizado com sucesso!", "", {
        duration: 5000,
        horizontalPosition: "right",
        verticalPosition: "top",
      });

      this.router.navigate(["produto/listar"]);
    });
  }

}

