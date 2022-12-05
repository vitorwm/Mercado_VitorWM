import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from 'src/app/_services/auth.service';
import { Usuario } from './../../../models/Usuario';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  id!: number;
  username!: string;
  email!: string;
  password!: string;

  constructor(
    private authService: AuthService,
    private router: Router,
    private snack: MatSnackBar,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {}

  cadastrar(): void {
    let usuario = new Usuario();

    usuario.id = this.id;
    usuario.username = this.username;
    usuario.email = this.email;
    usuario.password = this.password;

    this.authService.cadastrar(usuario).subscribe((usuario) => {
      console.log(usuario);
      this.snack.open('Usuário cadastrado com sucesso!', '', {
        duration: 5000,
        horizontalPosition: 'right',
        verticalPosition: 'top',
      });
      this.router.navigate(["usuario/login"]);
    });
  }
}
