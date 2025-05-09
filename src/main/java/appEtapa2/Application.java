package appEtapa2;

import lib.ArvoreBinaria;
import lib.IArvoreBinaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import app.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Application {

    private static final String NOME_ARQUIVO1 = "alunosOrdenados.txt";

    public static void main(String[] args) {

        Boolean continuar = true;

        Scanner s = new Scanner(System.in);

        //Instancio um comparador de alunos por matricula e nome
        ComparadorAlunoPorMatricula compPorMatricula = new ComparadorAlunoPorMatricula();
        ComparadorAlunoPorNome compPorNome = new ComparadorAlunoPorNome();
        IArvoreBinaria<Aluno> arvMatDegenerada, arvNomeDegenerada, arvMatBalanceada, arvNomeBalanceada;

        arvMatDegenerada = new ArvoreBinaria(compPorMatricula);
        arvNomeDegenerada = new ArvoreBinaria(compPorNome);

        //Faz o try-catch para a leitura do txt, se funcionando adiciona as informações em aluno e depois na arvore degenerada
        try (BufferedReader reader = new BufferedReader(new FileReader(NOME_ARQUIVO1))) {

            int numRegistros = Integer.parseInt(reader.readLine().trim());
            //System.out.println("Número de registros: " + numRegistros);

            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                int matricula = Integer.parseInt(partes[0]);
                String nome = partes[1];
                float nota = Float.parseFloat(partes[2]);

                arvMatDegenerada.adicionar(new Aluno(matricula, nome));
                arvNomeDegenerada.adicionar(new Aluno(matricula, nome));
            }


        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro ao processar um dos valores numéricos: " + e.getMessage());
        }

        while (continuar.equals(true)) {

            System.out.println("\nEscolha uma opção:");
            System.out.println("1 para adicionar um aluno na arvore");
            System.out.println("2 para pesquisar um aluno na arvore");
            System.out.println("3 para remover um aluno na arvore");
            System.out.println("4 para imprimir o caminho em ordem da arvore");
            System.out.println("0 para sair");

            String opcaoMenuGeral = s.nextLine();

            // Sai do menu se escolhida
            if (opcaoMenuGeral.equals("0")) {

                continuar = false;
            }

            // Inicia o menu para adicionar um aluno em uma das arvores
            if (opcaoMenuGeral.equals("1")) {

                Boolean continuarAdic = true;

                while (continuarAdic.equals(true)) {

                    System.out.println("\nDigite um dos numeros para selecionar a arvore a ter o aluno adicionado: ");
                    System.out.println("1 para arvore degenerada por matricula ");
                    System.out.println("2 para arvore degenerada por nome ");
                    System.out.println("0 para voltar");

                    String opcaoMenuAdicionar = s.nextLine();

                    if (opcaoMenuAdicionar.equals("0")) {
                        continuarAdic = false;
                    }

                    if (opcaoMenuAdicionar.equals("1") || opcaoMenuAdicionar.equals("2")) {

                        int matricula = 0;
                        Boolean entradaValida = false;

                        while (!entradaValida) {
                            try {
                                System.out.println("\nDigite a matrícula do aluno a ser adicionado: ");
                                matricula = s.nextInt();
                                s.nextLine();
                                entradaValida = true;
                            } catch (InputMismatchException e) {
                                System.err.println("Precisa ser um número inteiro. Tente novamente.");
                                s.nextLine();
                            }
                        }

                        System.out.println("\nDigite o nome do aluno a ser adicionado: ");
                        String nome = s.nextLine();

                        if (opcaoMenuAdicionar.equals("1")) {
                            arvMatDegenerada.adicionar(new Aluno(matricula, nome));
                            System.out.println("Aluno adicionado na arvore degenerada por matricula");
                        }

                        if (opcaoMenuAdicionar.equals("2")) {
                            arvNomeDegenerada.adicionar(new Aluno(matricula, nome));
                            System.out.println("Aluno adicionado na arvore degenerada por nome");
                        }
                    }
                }
            }

            if (opcaoMenuGeral.equals("2")) {

                Boolean continuarPesq = true;

                while (continuarPesq.equals(true)) {

                    System.out.println("\nDigite como será pesquisado: ");
                    System.out.println("1 para pesquisar usando a chave de criação da lista");
                    System.out.println("2 para pesquisar com uma chave especifica ");
                    System.out.println("0 para voltar");

                    String opcaoMenuPesquisar = s.nextLine();

                    if (opcaoMenuPesquisar.equals("0")) {
                        continuarPesq = false;
                    }

                    if (opcaoMenuPesquisar.equals("1")) {

                        Boolean continuarPesqArv = true;

                        while (continuarPesqArv.equals(true)) {

                            System.out.println("\nDigite um dos numeros para selecionar a arvore a ser pesquisa ");
                            System.out.println("1 para arvore degenerada por matricula ");
                            System.out.println("2 para arvore degenerada por nome ");
                            System.out.println("0 para voltar");

                            String opcaoMenuPesquisarArvore = s.nextLine();
                            Aluno resultado = null;

                            if (opcaoMenuPesquisarArvore.equals("0")) {
                                continuarPesqArv = false;
                            }

                            if (opcaoMenuPesquisarArvore.equals("1")) {

                                int matricula = 0;
                                Boolean entradaValida = false;

                                while (!entradaValida) {
                                    try {
                                        System.out.println("\nDigite a matrícula do aluno a ser pesquisado: ");
                                        matricula = s.nextInt();
                                        s.nextLine();
                                        entradaValida = true;
                                    } catch (InputMismatchException e) {
                                        System.err.println("Precisa ser um número inteiro. Tente novamente.");
                                        s.nextLine();
                                    }
                                }

                                resultado = arvMatDegenerada.pesquisar(new Aluno(matricula, ""));

                                if (resultado == null) {
                                    System.out.println("Aluno não encontrado");

                                } else {
                                    System.out.println("Aluno encontrado: " + resultado);

                                }

                            } else if (opcaoMenuPesquisarArvore.equals("2")) {

                                System.out.println("\nDigite o nome do aluno a ser pesquisado: ");
                                String nome = s.nextLine();

                                resultado = arvNomeDegenerada.pesquisar(new Aluno(0, nome));

                                if (resultado == null) {
                                    System.out.println("Aluno não encontrado");

                                } else {
                                    System.out.println("Aluno encontrado: " + resultado);

                                }
                            }
                        }
                    }

                    if (opcaoMenuPesquisar.equals("2")) {

                        Boolean continuarPesqArv = true;

                        while (continuarPesqArv.equals(true)) {

                            System.out.println("\nDigite um dos numeros para selecionar a comparacao a ser usada");
                            System.out.println("1 para comparar por matricula ");
                            System.out.println("2 para comparar por nome");
                            System.out.println("0 para voltar ");

                            String opcaoMenuPesquisarComp = s.nextLine();

                            if (opcaoMenuPesquisarComp.equals("0")) {
                                continuarPesqArv = false;
                            }

                            if (opcaoMenuPesquisarComp.equals("1")) {

                                Boolean continuarPesqCompMat = true;

                                while (continuarPesqCompMat.equals(true)) {

                                    System.out.println("\nDigite um dos numeros para selecionar a arvore a ser pesquisa ");
                                    System.out.println("1 para arvore degenerada por matricula ");
                                    System.out.println("2 para arvore degenerada por nome ");
                                    System.out.println("0 para voltar");

                                    String opcaoMenuPesquisarArvore = s.nextLine();
                                    Aluno resultado = null;

                                    if (opcaoMenuPesquisarArvore.equals("0")) {
                                        continuarPesqCompMat = false;
                                    }

                                    if (opcaoMenuPesquisarArvore.equals("1") || opcaoMenuPesquisarArvore.equals("2")) {

                                        int matricula = 0;
                                        Boolean entradaValida = false;

                                        while (!entradaValida) {
                                            try {
                                                System.out.println("\nDigite a matrícula do aluno a ser pesquisado: ");
                                                matricula = s.nextInt();
                                                s.nextLine();
                                                entradaValida = true;
                                            } catch (InputMismatchException e) {
                                                System.err.println("Precisa ser um número inteiro. Tente novamente.");
                                                s.nextLine();
                                            }
                                        }

                                        if (opcaoMenuPesquisarArvore.equals("1")) {
                                            resultado = arvMatDegenerada.pesquisar(new Aluno(matricula, ""), compPorMatricula);

                                        }

                                        if (opcaoMenuPesquisarArvore.equals("2")) {
                                            resultado = arvNomeDegenerada.pesquisar(new Aluno(matricula, ""), compPorMatricula);

                                        }

                                        if (resultado == null) {
                                            System.out.println("Aluno não encontrado");

                                        } else {
                                            System.out.println("Aluno encontrado: " + resultado);

                                        }
                                    }
                                }
                            }

                            if (opcaoMenuPesquisarComp.equals("2")) {

                                Boolean continuarPesqCompNome = true;

                                while (continuarPesqCompNome) {

                                    System.out.println("\nDigite um dos numeros para selecionar a arvore a ser pesquisa ");
                                    System.out.println("1 para arvore degenerada por matricula ");
                                    System.out.println("2 para arvore degenerada por nome ");
                                    System.out.println("0 para voltar XD ");

                                    String opcaoMenuPesquisarArvore = s.nextLine();
                                    Aluno resultado = null;

                                    if (opcaoMenuPesquisarArvore.equals("0")) {
                                        continuarPesqCompNome = false;
                                    }

                                    if (opcaoMenuPesquisarArvore.equals("1") || opcaoMenuPesquisarArvore.equals("2")) {

                                        System.out.println("\nDigite o nome do aluno a ser pesquisado: ");
                                        String nome = s.nextLine();

                                        if (opcaoMenuPesquisarArvore.equals("1")) {
                                            resultado = arvMatDegenerada.pesquisar(new Aluno(0, nome), compPorNome);

                                        }

                                        if (opcaoMenuPesquisarArvore.equals("2")) {
                                            resultado = arvNomeDegenerada.pesquisar(new Aluno(0, nome), compPorNome);

                                        }

                                        if (resultado == null) {
                                            System.out.println("Aluno não encontrado");

                                        } else {
                                            System.out.println("Aluno encontrado: " + resultado);

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (opcaoMenuGeral.equals("3")) {

                Boolean continuarRem = true;

                while (continuarRem.equals(true)) {

                    System.out.println("\nDigite um dos numeros para selecionar a arvore a ter um aluno removido ");
                    System.out.println("1 para arvore degenerada por matricula ");
                    System.out.println("2 para arvore degenerada por nome ");
                    System.out.println("0 para voltar ");

                    String opcaoMenuRemover = s.nextLine();
                    Aluno resultado = null;

                    if (opcaoMenuRemover.equals("0")) {
                        continuarRem = false;
                    }

                    if (opcaoMenuRemover.equals("1")) {

                        int matricula = 0;
                        Boolean entradaValida = false;

                        while (!entradaValida) {
                            try {
                                System.out.println("\nDigite a matrícula do aluno a ser removido: ");
                                matricula = s.nextInt();
                                s.nextLine(); // limpa o buffer
                                entradaValida = true;
                            } catch (InputMismatchException e) {
                                System.err.println("Precisa ser um número inteiro. Tente novamente.");
                                s.nextLine(); // limpa a entrada inválida do scanner
                            }
                        }

                        arvMatDegenerada.remover(new Aluno(matricula, ""));

                    }

                    if (opcaoMenuRemover.equals("2")) {
                        System.out.println("\nDigite o nome do aluno a ser removido: ");
                        String nome = s.nextLine();

                        if (opcaoMenuRemover.equals("2")) {
                            arvNomeDegenerada.remover(new Aluno(0, nome));

                        }
                    }
                }
            }

            if (opcaoMenuGeral.equals("4")) {

                Boolean continuarCaminhoOrdem = true;

                while (continuarCaminhoOrdem.equals(true)) {

                    System.out.println("\nDigite um dos numeros para selecionar a arvore ter seu caminho em order mostrada ");
                    System.out.println("1 para arvore degenerada por matricula ");
                    System.out.println("2 para arvore degenerada por nome ");
                    System.out.println("0 para voltar ");

                    String opcaoMenuCaminhoOrdem = s.nextLine();
                    String resultado = "";

                    if (opcaoMenuCaminhoOrdem.equals("0")) {
                        continuarCaminhoOrdem = false;
                    }

                    if (opcaoMenuCaminhoOrdem.equals("1") || opcaoMenuCaminhoOrdem.equals("2")) {

                        if (opcaoMenuCaminhoOrdem.equals("1")) {
                            resultado = arvMatDegenerada.caminharEmOrdem();

                        }

                        if (opcaoMenuCaminhoOrdem.equals("2")) {
                            resultado = arvNomeDegenerada.caminharEmOrdem();

                        }

                        System.out.println(resultado);
                    }
                }
            }
        }

        s.close();
    }
}