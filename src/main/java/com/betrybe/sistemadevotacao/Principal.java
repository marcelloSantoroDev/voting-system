package com.betrybe.sistemadevotacao;

import java.util.Objects;
import java.util.Scanner;

/**
 * The type Principal.
 */
public class Principal {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();

    System.out.println("Cadastrar pessoa candidata?");
    System.out.println("1 - Sim");
    System.out.println("2 - Não");
    System.out.println("Entre com o número correspondente à opção desejada:");

    int resCadastroCandidato = scanner.nextInt();

    while (resCadastroCandidato == 1) {
      System.out.println("Entre com o nome da pessoa candidata:");
      String nomeCandidato = scanner.next();
      System.out.println("Entre com o número da pessoa candidata:");
      int numeroCandidato = scanner.nextInt();

      gerenciamentoVotacao.cadastrarPessoaCandidata(nomeCandidato, numeroCandidato);

      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");

      resCadastroCandidato = scanner.nextInt();
    }

    System.out.println("Cadastrar pessoa eleitora?");
    System.out.println("1 - Sim");
    System.out.println("2 - Não");
    System.out.println("Entre com o número correspondente à opção desejada:");

    int resCadastroEleitor = scanner.nextInt();

    while (resCadastroEleitor == 1) {
      System.out.println("Entre com o nome da pessoa eleitora:");
      String nomeEleitor = scanner.next();
      System.out.println("Entre com o cpf da pessoa candidata:");
      String cpfEleitor = scanner.next();

      gerenciamentoVotacao.cadastrarPessoaEleitora(nomeEleitor, cpfEleitor);

      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");

      resCadastroEleitor = scanner.nextInt();
    }

    System.out.println(" Entre com o número correspondente à opção desejada:");
    System.out.println("1 - Votar");
    System.out.println("2 - Resultado Parcial");
    System.out.println("3 - Finalizar Votação");

    int opcao = scanner.nextInt();

    while (opcao != 3) {

      switch (opcao) {
        case 1:
          System.out.println("Entre com o cpf da pessoa eleitora:");
          String cpfEleitor = scanner.next();
          System.out.println("Entre com o número da pessoa candidata:");
          int numeroCandidato = scanner.nextInt();

          gerenciamentoVotacao.votar(cpfEleitor, numeroCandidato);
          break;
        case 2:
          gerenciamentoVotacao.mostrarResultado();
          break;
        default:
          System.out.println("Opção inválida");
          break;
      }

      System.out.println(" Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");

      opcao = scanner.nextInt();

    }


  }

}
