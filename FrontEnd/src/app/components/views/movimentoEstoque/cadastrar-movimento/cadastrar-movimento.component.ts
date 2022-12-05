import { MovEstoque } from './../../../../models/MovEstoque';
import { MovEstoqueService } from './../../../../services/movEstoque.service';
import { TipoMovimento } from 'src/app/models/MovEstoque';
import { MatSnackBar } from '@angular/material/snack-bar';
import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-cadastrar-movimento',
  templateUrl: './cadastrar-movimento.component.html',
  styleUrls: ['./cadastrar-movimento.component.css']
})
export class CadastrarMovimentoComponent implements OnInit {

  id_!: number;
  tipoMovimentacao!: TipoMovimento;
  valorVenda!: number;
  qtdeMovimentada!: number;
  data!: Date;
  produto!:{id: number;} ;
  codigo!: number

  constructor( private movEstoqueService: MovEstoqueService, private router: Router, private snack: MatSnackBar, private route: ActivatedRoute) {}

  ngOnInit(): void {
  }

  cadastrar(): void {

    let movEstoque = new MovEstoque();

    movEstoque.id = this.id_;
    movEstoque.produto = {id: this.codigo };
    movEstoque.tipoMovimentacao = this.tipoMovimentacao;
    movEstoque.qtdeMovimentada = this.qtdeMovimentada;
    movEstoque.data = this.data;

    if(movEstoque.tipoMovimentacao == 'SAIDA'){
      movEstoque.valorVenda =(this.valorVenda);
    }

    this.movEstoqueService.cadastrar(movEstoque).subscribe(movEstoque => {
    console.log(movEstoque);
    this.snack.open("Nova Movimentação de Estoque cadastrada com sucesso!", "", {
      duration: 5000,
      horizontalPosition: "right",
      verticalPosition: "top",
      });

      this.router.navigate(["estoque/movimentacoes/"]);
    },err => {
      if (err instanceof HttpErrorResponse)
      {
          if (err.status === 404)
          {
            console.log(err)
            this.snack.open("ERRO 404! NÃO HÁ ESTOQUE SUFICIENTE!", "", {
              duration: 5000,
              horizontalPosition: "center",
              verticalPosition: "top",
            });
          }
      }
    })
  }
}
