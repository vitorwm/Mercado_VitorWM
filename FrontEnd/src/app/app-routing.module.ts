import { HomeComponent } from './components/views/home/home.component';
import { CadastrarMovimentoComponent } from './components/views/movimentoEstoque/cadastrar-movimento/cadastrar-movimento.component';
import { ListarPorTipoComponent } from './components/views/movimentoEstoque/listar-por-tipo/listar-por-tipo.component';
import { ListarLucroComponent } from './components/views/movimentoEstoque/listar-lucro/listar-lucro.component';
import { AtualizarComponent } from './components/views/produto/atualizar/atualizar.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastrarComponent } from './components/views/produto/cadastrar/cadastrar.component';
import { ListarComponent } from './components/views/produto/listar/listar.component';
import { ListarMovimentoComponent } from './components/views/movimentoEstoque/listar/listar.component';
import { LoginComponent } from './components/views/login/login.component';
import { RegisterComponent } from './components/views/register/register.component';
import { ProfileComponent } from './components/views/profile/profile.component';
import { AuthInterceptor} from 'src/app/_helpers/auth.interceptor';
import { HTTP_INTERCEPTORS } from '@angular/common/http';

const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent
  },
  { path: 'usuario/login',
    component: LoginComponent
  },
  { path: 'usuario',
    component: RegisterComponent
  },
  { path: 'profile',
    component: ProfileComponent
  },
  {
    path: 'produto/novo',
    component: CadastrarComponent
  },
  {
    path: 'produto/listar',
    component: ListarComponent
  },
  {
  path: 'produto/atualiza/:id',
  component: AtualizarComponent
  },
  {
    path: 'estoque/movimentacoes',
    component: ListarMovimentoComponent
  },
  {
    path: 'estoque/movimento',
    component: CadastrarMovimentoComponent
  },
  {
    path: 'estoque/movimentofinanceiro',
    component: ListarLucroComponent
  },
  {
    path: 'estoque/movimentoprodutoportipo',
    component: ListarPorTipoComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
  ]
})
export class AppRoutingModule { }
