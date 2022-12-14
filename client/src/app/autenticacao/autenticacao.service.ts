import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { UsuarioService } from './usuario/usuario.service';
import { tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AutenticacaoService {
  constructor(
    private httpClient: HttpClient,
    private usuarioService: UsuarioService
    ) { }

  autenticar(usuario: string, senha: string): Observable<HttpResponse<any>> {
    const URL: string = 'http://localhost:3000/user/login';
    const autenticar = this.httpClient.post(URL, {
      userName: usuario,
      password: senha,
    }, { observe: 'response' }
    ).pipe(
      tap((response) => {
        const authToken = response.headers.get('x-access-token') ?? '';
        this.usuarioService.salvaToken(authToken);
      })
    );

    return autenticar;
  }
}
