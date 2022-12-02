import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
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
  displayedColumns: string[] = ['id', 'descricao', 'tipo', 'valorFornecedor', 'estoque' , 'editar', 'deletar'];


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


  atualizar(id:any){
    this.router.navigate(['produto/atualiza/'+id
  ])
 }

 applyFilter(event: Event) {
  const filterValue = (event.target as HTMLInputElement).value;
  this.produtos.filter = filterValue.trim().toLowerCase();
}
}


