import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Carro } from './carro';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CarroService {
  private urlApi = environment.urlApi;

  constructor(private http: HttpClient) { }

  public listarCarro(id: number): Observable<Carro> {
    return this.http.get<Carro>(`${this.urlApi}/carro/pesquisar/${id}`)
  }

  public listarCarros(): Observable<Carro[]> {
    return this.http.get<Carro[]>(`${this.urlApi}/carro/todos`);
  }

  public adicionarCarro(carro: Carro): Observable<Carro> {
    return this.http.post<Carro>(`${this.urlApi}/carro/adicionar`, carro);
  }

  public atualizarCarro(carro: Carro): Observable<Carro> {
    return this.http.put<Carro>(`${this.urlApi}/carro/atualizar`, carro);
  }

  public deletarCarro(id: number): Observable<void> {
    return this.http.delete<void>(`${this.urlApi}/carro/deletar/${id}`);
  }
}