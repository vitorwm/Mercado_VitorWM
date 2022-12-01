import { AtualizarComponent } from './components/views/produto/atualizar/atualizar.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastrarComponent } from './components/views/produto/cadastrar/cadastrar.component';
import { ListarComponent } from './components/views/produto/listar/listar.component';
import { ListarMovimentoComponent } from './components/views/movimentoEstoque/listar/listar.component';


const routes: Routes = [
  {
    path: '',
    component: ListarComponent
  },
  {
    path: 'produto/novo',
    component: CadastrarComponent
  },
  {
  path: 'produto/atualiza/:id',
  component: AtualizarComponent
  },
  {
    path: 'estoque/movimentacoes',
    component: ListarMovimentoComponent
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
