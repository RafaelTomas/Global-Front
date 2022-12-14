import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NovoUsuario } from './novo-usuario';

@Injectable({
  providedIn: 'root'
})
export class NovoUsuarioService {
  URL: string = 'http://localhost:3000/user/signup';
  constructor(private httpClient: HttpClient) { }

  cadastrarNovoUsuario(novoUsuario: NovoUsuario) {
    const novoUsuarioCadastrado = this.httpClient.post(this.URL, novoUsuario)

    return novoUsuarioCadastrado;
  }




}
