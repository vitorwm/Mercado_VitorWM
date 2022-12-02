import { MovEstoque } from './../../../../models/MovEstoque';
import { MovEstoqueService } from './../../../../services/movEstoque.service';
import { Component, OnInit } from '@angular/core';
import { TipoMovimento } from 'src/app/models/MovEstoque';
import { Produto } from 'src/app/models/Produto';
import { ActivatedRoute, Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

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
    });
  }

}
