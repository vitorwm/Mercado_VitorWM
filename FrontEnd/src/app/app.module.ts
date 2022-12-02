import { AtualizarComponent } from './components/views/produto/atualizar/atualizar.component';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule, NoopAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatTableModule } from '@angular/material/table';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatSelectModule } from '@angular/material/select';

import { AppComponent } from './app.component';
import { ContentComponent } from './components/template/content/content.component';
import { HeaderComponent } from './components/template/header/header.component';
import { CadastrarComponent } from './components/views/produto/cadastrar/cadastrar.component';
import { ListarComponent } from './components/views/produto/listar/listar.component';
import { MatDialogModule } from '@angular/material/dialog';
import { ListarMovimentoComponent } from './components/views/movimentoEstoque/listar/listar.component';
import { ListarLucroComponent } from './components/views/movimentoEstoque/listar-lucro/listar-lucro.component';
import { ListarPorTipoComponent } from './components/views/movimentoEstoque/listar-por-tipo/listar-por-tipo.component';
import { CadastrarMovimentoComponent } from './components/views/movimentoEstoque/cadastrar-movimento/cadastrar-movimento.component';




@NgModule({
  declarations: [
    AppComponent,
    ContentComponent,
    HeaderComponent,
    CadastrarComponent,
    AtualizarComponent,
    ListarComponent,
    ListarMovimentoComponent,
    ListarLucroComponent,
    ListarPorTipoComponent,
    CadastrarMovimentoComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NoopAnimationsModule,
    MatToolbarModule,
    MatTableModule,
    MatButtonModule,
    MatIconModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatDialogModule,
    MatSidenavModule,
    MatListModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatTableModule,
    MatSnackBarModule,
    MatSelectModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
