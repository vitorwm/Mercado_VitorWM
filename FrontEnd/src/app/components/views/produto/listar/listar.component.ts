import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Produto } from 'src/app/models/Produto';
import { ProdutoService } from 'src/app/services/produto.service';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {
  produtos!: MatTableDataSource<Produto>;
  displayedColumns: string[] = ['id', 'descricao', 'tipo', 'valorFornecedor', 'estoque' , 'deletar'];

  constructor(private service: ProdutoService, private router:Router) {}

  ngOnInit(): void {
    this.service.listar().subscribe((produtos) => {
      this.produtos = new MatTableDataSource<Produto>(produtos);
    });
  }

  deletar(id: number) {
    this.service.deletar(id).subscribe(data => {this.service.listar().subscribe((produtos) => {
      this.produtos = new MatTableDataSource<Produto>(produtos);
    });})

  }

 /* atualizar(){
    this.service.atualizar(this.produtos, Produto).subscribe(
      (resp) => {
        console.log(resp);
      },
      (err) => {
        console.log(err);
      }
    );
  }
*/
  atualizar(id:any){
    this.router.navigate(['produto/atualizar/'+id
  ])
 }


}
