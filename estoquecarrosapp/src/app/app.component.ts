import { Component, OnInit } from '@angular/core';
import { Carro } from './carro';
import { CarroService } from './carro.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public carros: Carro[] = [];
  public formularioAberto: boolean = false;
  public confirmacaoAberta: boolean = false;
  public acao: string = '';
  public idCarro: number = 0;
  public carro: Carro = new Carro();

  constructor(private servico: CarroService) { }

  ngOnInit(): void {
    this.listarCarros();
  }

  public abrirFormulario(acao: string): void {
    this.formularioAberto = true;
    this.acao = acao;
  }

  public fecharFormulario(): void {
    this.formularioAberto = false;
  }

  public abrirConfirmacao(carro: Carro): void {
    this.confirmacaoAberta = true;
    this.carro = carro;
  }

  public fecharConfirmacao(): void {
    this.confirmacaoAberta = false;
  }



  public listarCarros(): void {
    this.servico.listarCarros().subscribe(
      (retorno: Carro[]) => {
        this.carros = retorno;
      }
    );
  }

  public enviarCarro(addForm: NgForm): void {
    if (this.acao == 'Adicionar') {
      this.servico.adicionarCarro(addForm.value).subscribe(
        (retorno: Carro) => {
          this.listarCarros();
          addForm.reset();
          this.fecharFormulario();
        }
      );
    }
    else {
      addForm.value.id = this.idCarro;
      this.servico.atualizarCarro(addForm.value).subscribe(
        (retorno: Carro) => {
          this.listarCarros();
          addForm.reset();
          this.fecharFormulario();
        }
      );
    }
  }

  public atualizarCarro(id: number) {
    this.idCarro = id;
    this.abrirFormulario('Atualizar');
  }

  public deletarCarro(): void {
    this.servico.deletarCarro(this.carro.id).subscribe(
      (retorno: void) => {
        this.listarCarros();
        this.fecharConfirmacao();
      }
    );
  }
}