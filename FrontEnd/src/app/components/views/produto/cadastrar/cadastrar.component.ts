import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router, ActivatedRoute } from '@angular/router';
import { Produto, TipoProduto } from 'src/app/models/Produto';
import { ProdutoService } from 'src/app/services/produto.service';

@Component({
  selector: 'app-cadastrar',
  templateUrl: './cadastrar.component.html',
  styleUrls: ['./cadastrar.component.css']
})
export class CadastrarComponent implements OnInit {

  id!: number;
  descricao!: string;
  preco!: number;
  valorFornecedor!: number;
  estoque!: number;
  tipo!: TipoProduto;

  constructor( private produtoService: ProdutoService, private router: Router, private snack: MatSnackBar, private route: ActivatedRoute) {}


ngOnInit(): void {}


  cadastrar(): void {

    let produto = new Produto();

    produto.id = this.id;
    produto.descricao = this.descricao;
    produto.tipo =(this.tipo);
    produto.valorFornecedor = this.valorFornecedor;
    produto.estoque = this.estoque;

    this.produtoService.cadastrar(produto).subscribe(produto => {
      console.log(produto);
      this.snack.open("Novo Produto cadastrado com sucesso!", "", {
        duration: 5000,
        horizontalPosition: "right",
        verticalPosition: "top",
      });

      this.router.navigate(["produto/listar"]);
    });
  }

}
