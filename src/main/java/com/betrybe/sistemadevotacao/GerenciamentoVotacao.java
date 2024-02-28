package com.betrybe.sistemadevotacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * The type Gerenciamento votacao.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {
  protected ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  protected ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  protected ArrayList<String> cpfsComputados = new ArrayList<String>();

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    boolean pessoaEstaCadastrada = false;

    for (PessoaCandidata pessoa : pessoasCandidatas) {
      if (Objects.equals(pessoa.getNumero(), numero)) {
        pessoaEstaCadastrada = true;
        break;
      }
    }

    if (!pessoaEstaCadastrada) {
      PessoaCandidata novoCandidato = new PessoaCandidata(numero, nome);
      this.pessoasCandidatas.add(novoCandidato);
    } else {
      System.out.println("Número da pessoa candidata já utilizado!");
    }
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    boolean pessoaEstaCadastrada = false;

    for (PessoaEleitora pessoa : pessoasEleitoras) {
      if (Objects.equals(pessoa.getCpf(), cpf)) {
        pessoaEstaCadastrada = true;
        break;
      }
    }

    if (!pessoaEstaCadastrada) {
      PessoaEleitora novoEleitor = new PessoaEleitora(cpf, nome);
      this.pessoasEleitoras.add(novoEleitor);
    } else {
      System.out.println("Pessoa eleitora já cadastrada!");
    }
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    boolean pessoaJaVotou = false;

    for (String cpf : cpfsComputados) {
      if (Objects.equals(cpf, cpfPessoaEleitora)) {
        pessoaJaVotou = true;
        break;
      }
    }

    if (pessoaJaVotou) {
      System.out.println("Pessoa eleitora já votou!");
    } else {
      for (PessoaCandidata pessoa : pessoasCandidatas) {
        if (Objects.equals(pessoa.getNumero(), numeroPessoaCandidata)) {
          pessoa.receberVoto();
          cpfsComputados.add(cpfPessoaEleitora);
        }
      }
    }

  }

  @Override
  public void mostrarResultado() {
    if (cpfsComputados.isEmpty()) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado");
    } else {
      int totalDeVotos = cpfsComputados.size();
      for (PessoaCandidata pessoa : pessoasCandidatas) {
        double porcentagemDeVotos = (double) (pessoa.getVotos() * 100) / totalDeVotos;
        System.out.println("Nome: "
            + pessoa.getNome()
            + " - " + pessoa.getVotos()
            + " votos "
            + "( "
            + Math.round(porcentagemDeVotos)
            + " )");
      }
      System.out.println("Total de votos: " + totalDeVotos);
    }
  }
}


