import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class AutenticacaoService {
  constructor(private httpClient: HttpClient) { }

  autenticar(usuario: string, senha: string): Observable<any> {
    const URL: string = 'http://localhost:3000/user/login';

    const autenticar = this.httpClient.post(URL, {
      userName: usuario,
      password: senha,
    });

    return autenticar;
  }

}
