import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from 'src/app/_services/token-storage.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  currentUser: any;
  userMain: any;

  constructor(private token: TokenStorageService) { }

  ngOnInit(): void {
    this.userMain = this.token.getUser();
    this.currentUser = this.userMain.usuario;
  }
}
